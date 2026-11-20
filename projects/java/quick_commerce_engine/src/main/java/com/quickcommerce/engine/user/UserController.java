package com.quickcommerce.engine.user;


import com.quickcommerce.engine.auth.service.AuthService;
import org.springframework.web.bind.annotation.*;

/**
 * 
 *
 *  represents multiple Entity differentiated by their roleType ( Customer , DeliveryPartner , Packer , StoreManager , SystemAdmin )
 *
 *<p>Each Role has access to their respective responsibilities described in the securityConfig. </p>
 *
 */

@RestController

public class UserController {}
