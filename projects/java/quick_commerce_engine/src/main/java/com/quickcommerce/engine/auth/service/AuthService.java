package com.quickcommerce.engine.auth.service;

import com.quickcommerce.engine.auth.dto.LoginResponse;
import com.quickcommerce.engine.auth.dto.RegisterRequest;
import com.quickcommerce.engine.common.exceptions.DuplicateEmailException;
import com.quickcommerce.engine.common.exceptions.UserNotFoundException;
import com.quickcommerce.engine.customer.model.CustomerCart;
import com.quickcommerce.engine.customer.model.CustomerProfile;
import com.quickcommerce.engine.customer.repository.CustomerCartRepository;
import com.quickcommerce.engine.customer.repository.CustomerRepository;
import com.quickcommerce.engine.user.model.User;
import com.quickcommerce.engine.user.enums.Role;
import com.quickcommerce.engine.auth.RefreshTokenRepository;
import com.quickcommerce.engine.user.repository.UserRepository;
import com.quickcommerce.engine.common.exceptions.security.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final RefreshTokenRepository refreshTokenRepository;
    private final CustomerCartRepository customerCartRepository;
    private final CustomerRepository customerRepository;


    @Transactional
    public void register(RegisterRequest req){
        if(emailExists(req.getEmail())) throw new DuplicateEmailException("account with " + req.getEmail() + " already exists");

        User user = new User();

        user.setUsername(req.getName());
        user.setEmail(req.getEmail());

        user.setPassword_hash(passwordEncoder.encode(req.getPassword()));

        user.setRole(Role.CUSTOMER);  // by default customer


        user.setActive(true);// set to true
        // save the user first
        User savedUser = userRepository.save(user);


        // then also create the customer profile at register (using this endpoint, other roles eg. packer , delivery driver must be created using sperate endpoints or i'll introduce role, figure this out later
        CustomerProfile customerProfile = new CustomerProfile();
        customerProfile.setUser(savedUser);

        CustomerCart cart = new CustomerCart();
        cart.setCustomer(customerProfile);
        customerProfile.setCart(cart);

        // only save the customer profile (casecade.all will auto create in customerCart
        customerRepository.save(customerProfile);

    }


    public LoginResponse login(String email , String password){


        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();


        User user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow(() -> new UserNotFoundException("No user found with " + userDetails.getUsername()));

        String accessToken = jwtUtil.generateToken(user);

      return new LoginResponse(user , accessToken);
    };


//    public ResponseEntity<?> refresh(String rawRefreshToken , HttpServletResponse response){
//
//        Claims claims;
//
//        try{
//           claims = jwtUtil.parseRefreshToken(rawRefreshToken);
//        }catch(JwtException e){
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//
//        String tokenId = claims.getId();
//
//        RefreshToken storedToken = refreshTokenRepository.findByTokenIdAndRevokedFalse(tokenId).orElse(null);
//
//        if(storedToken == null || storedToken.getExpiresAt().isBefore(Instant.now())){
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//
//        // rotate the token
//        storedToken.setRevoked(true);
//        refreshTokenRepository.save(storedToken);
//
//        User user =  storedToken.getUser();
//
//        // implementation left.
//    }

    private boolean emailExists(String email){
        return userRepository.existsByEmail(email);
    }
}
