package jx05;

class Args2{
    public static void main(String[] args){
        String valStr;
        int valInt;
        double valDouble;

        for (String arg : args) {
        	try {
            	valInt = Integer.parseInt(arg);
            	System.out.println("valInt = " + valInt);
            }catch(NumberFormatException e){
            	try {
            		valDouble = Double.parseDouble(arg);
            		System.out.println("valDouble = " + valDouble);
            	}catch(NumberFormatException ee) {
            		valStr = arg;
            		System.out.println("valStr = " + valStr);
            	}

            }
        }

    }
}
