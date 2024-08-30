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
    public static void main( String[] args )
    {
        App app = new App();

        int resultMyfunction = app.myFunction(3, 7);
        int resultF = app.f(5);
        int resultG = app.g();

        System.out.println("Result of myFunction(3,7): " + resultMyfunction);
        System.out.println("Result of f(5): " + resultF);
        System.out.println("Result of g(): " + resultG);
    }
}
