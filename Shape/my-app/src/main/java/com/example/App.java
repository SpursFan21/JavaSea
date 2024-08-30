package com.example;

public class App 
{
    int myFunction(int x, int y){
        int z = 2 * x - y;
        return z * x;
    }
    int f(int n){
        return 3+ myFunction(n, n+1);
    }
    int g(){
        int a;
        a = myFunction(3, 7);
        int b = f(a * a);
        return b;
    }
    int ff(int x1) {
        return x1 * 2 - 1;
      }
      
      int h() {
        int a1 = 3;
        int b1 = ff(a1) + ff(4);
        return b1;
      }
    public static void main( String[] args )
    {
        App app = new App();

        int resultMyfunction = app.myFunction(3, 7);
        int resultF = app.f(5);
        int resultG = app.g();
        int resultFF = app.ff(3);
        int resultH = app.h();

        System.out.println("Result of myFunction(3,7): " + resultMyfunction);
        System.out.println("Result of f(5): " + resultF);
        System.out.println("Result of g(): " + resultG);
        System.out.println("Result of ff: " + resultFF);
        System.out.println("Result of h: " + resultH);
    }
}