- use the `useDispatch` from `react-redux`
 ```jsx
      const [depositAmount, setDepositAmount] = useState("");
        
        const dispatch = useDispatch();
      
        const {
          loan,
          balance,
          loanPurpose: loanP,
        } = useSelector((store) => store.account);
      
        function handleDeposit() {
          if (!depositAmount) return;
      
          dispatch(deposit(depositAmount)); // here the "deposit" action creator is coming from accountSlice.js
        }
    ```