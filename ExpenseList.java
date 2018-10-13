
//ExpenseList class
//Defines an unordered list of Expense objects
//Uses the generic unordered list (List<T>) class and Expense class
public class ExpenseList {
    private List<Expense> expenses;


    public ExpenseList() {
        expenses = new List<Expense>();
    }

    public void add(Expense exp) {
        expenses.add(exp);
    }

    public boolean isEmpty() {
        return expenses.isEmpty();
    }

    public boolean contains(Expense exp) {
        return expenses.contains(exp);
    }

    public Expense first() {
        return expenses.first();
    }

    public Expense next() {
        return expenses.next();
    }

    public void enumerate() {
        expenses.enumerate();
    }

    public double maxExpense() {
        double max = 0.0, amt;
        Expense exp = expenses.first();
        while (exp != null) {
            amt = exp.getAmount();
            if (amt > max)
                max = amt;
            exp = expenses.next();
        }
        return max;
    }

    public double minExpense() {
        double min = Double.MAX_VALUE, amt;
        Expense exp = expenses.first();
        if (exp == null) return 0.0;
        else {

            while (exp != null) {
                amt = exp.getAmount();
                if (amt < min)
                    min = amt;
                exp = expenses.next();
            }
        }
        return min;
    }

    public double avgExpense() {
        //TODO: complete this method
        //Finds the average of all expenses
        int num = 0;
        double total = 0.0;
        double amt;
        Expense exp = expenses.first();
        if (exp == null) {
            return 0.0;
        } else {
            while (exp != null) {
                amt = exp.getAmount();
                total += amt;
                num++;
                exp = expenses.next();
            }
        }
        return total / num;
    }

    public double totalExpense() {
        //TODO: complete this method
        //Finds the sum of all expenses
        double total = 0.0;
        double amt;
        Expense exp = expenses.first();
        if (exp == null) {
            return 0.0;
        } else {
            while (exp != null) {
                amt = exp.getAmount();
                total += amt;
                exp = expenses.next();
            }
        }
        return total;
    }

    public double amountSpentOn(String expItem) {
        //TODO: complete this method
        //Finds the amount spent on a particular item
        Expense exp = expenses.first();
        double num = 0;
        if (exp == null) {
            return 0.0;
        } else {
            while (exp != null) {
                if (exp.getItem().equals(expItem)) {
                    num += exp.getAmount();
                }
                exp = expenses.next();
            }
        }
        return num;
    }
}
