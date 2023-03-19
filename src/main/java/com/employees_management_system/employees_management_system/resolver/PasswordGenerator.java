package com.employees_management_system.employees_management_system.resolver;

import java.util.Random;

public class PasswordGenerator {
    private static  final  String lCase = "abcdefghijklmnopqrstuvwxyz";
    private static  final  String uCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static  final  String sCase ="!@$%^&*";
    private static  final String digits = "0123456789";
    private static Random random = new Random();
    private  static  StringBuilder sb = new StringBuilder();

    private  static  final  int len = 10;

    public   static String generateRandomPassword(){
        System.out.println("Random Password");
        while (sb.length() != len){
            int rPick = random.nextInt(4);
            if (rPick == 0){
                int spot  = random.nextInt(26);
                sb.append(lCase.charAt(spot));
            } else if (rPick ==1 ) {
                int spot= random.nextInt(26);
                sb.append(uCase.charAt(spot));

            } else if (rPick ==2) {
                int spot = random.nextInt(8);
                sb.append(sCase.charAt(spot));

            } else  {

                int spot = random.nextInt(10);
                sb.append(digits.charAt(spot));

            }

        }
        return sb.toString();
    }
private  static  int l = 8;
    public static String getPassword() {

        while (sb.length() != l) {
            int rp = random.nextInt(4);
                if (rp == 0) {
                    int spots = random.nextInt(26);
                    if (spots == 2) {
                        sb.append(uCase.charAt(spots));
                    }

                } else if (rp == 1) {
                    int spots = random.nextInt(26);
                    if (spots == 2) {
                        sb.append(lCase.charAt(spots));
                    }

                } else if (rp == 3) {
                    int spots = random.nextInt(7);
                    if (spots == 2) {
                        sb.append(sCase.charAt(2));
                    }
                } else {
                    int spots = random.nextInt(10);
                    if (spots == 2) {
                        sb.append(digits.charAt(spots));
                    }
                }


        }
        return sb.toString();
    }


}
