package com.example.firstapp;

class JavaTest {
    public String name = "Tony";
    public static void foo(){

    }
}

class Another{

}

class ThirdClass {

    private String name;
   public ThirdClass() {
        init();
   }
    public ThirdClass(String someValue){
        this.name = someValue;
    }

    public void updateName(String newName) {
       this.name = newName;
    }
    private void init() {

    }
}