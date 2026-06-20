class Bank {
    private final long[] balance;
    private final int size;

    public Bank(long[] balance) {
        this.balance = balance;
        this.size = balance.length;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        // Validar cuenta 1 y 2, es decir que esten en el array
        // Validar Dinero cuenta 1 <= money

        if (
            isValidAccount(account1) &&
            isValidAccount(account2) &&
            balance[account1 - 1] >= money
        ){
            balance[account1 - 1] -= money;
            balance[account2 - 1] += money;
            // balance[account1] = balance[account1] - money

            return true;
        }

        return false;
    }
    
    public boolean deposit(int account, long money) {
        if (isValidAccount(account)) {
            balance[account - 1] += money;

            return true;
        }

        return false;
    }
    
    public boolean withdraw(int account, long money) {
        if (
            isValidAccount(account) && balance[account - 1] >= money
        ) {
            balance[account - 1] -= money;

            return true;
        }

        return false;
        
    }

    public boolean isValidAccount(int account) {
        /**        
        if(account > 0 && account <= size) {
            return true;
        } else {
            return false;
        }
         */

         return account > 0 && account <= size;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */