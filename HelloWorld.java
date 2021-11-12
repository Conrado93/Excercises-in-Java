package com.dzone.example;


//import StdDraw;
import java.awt.Color;
import java.util.*;
import java.util.function.*;
//import static java.util.Comparator.*;
//import static java.util.stream.Collectors.*;
//import java.util.stream.Collector;
import java.lang.*;
import java.util.concurrent.*;
import java.io.*;



/*

class klon implements Cloneable
{
    int a;
    int b;
    klon(int x, int y){a=x; b=y;}
    
    klon klonowanie()
    {
        klon tempor;
        try{
        return (klon) super.clone();
        }catch(CloneNotSupportedException c)
        {
            System.out.println("Coś poszło nie tak");
            return this;
        }
        

    }
}



class Rekur extends RecursiveAction
{
    
    double tab[];
    int start, end, koniec;
    Rekur(double[] x, int s, int e, int prog)
    {
        tab=x;
        this.start=s; this.end=e; this.koniec=prog;
    }
    @Override protected void compute()
    {
        if(this.end-this.start<this.koniec)
        {
            
            for(int i=start;i<=end;i++)tab[i]=Math.sqrt(tab[i]);
        
        }else
        {
            int temp=this.end-this.start;
            temp=temp/2;
            invokeAll(new Rekur(tab, this.start, this.start+temp-1, this.koniec), new Rekur(tab, this.start+temp, this.end, this.koniec));
            
        }
    }
}
 */
class Sum extends RecursiveTask<Integer>
{

    Integer[] tablica;
    int start, koniec;
    Sum(Integer[] table, int on, int off)
    {
        tablica=table; this.start=on; this.koniec=off;
    }

@Override protected Integer compute()
{
Integer suma;
    if((this.koniec-this.start)<10)
    {
        suma=0;
        for(int i=this.start;i<=this.koniec;i++)suma+=tablica[i];
        
    }else
    {
        int middle=this.koniec+this.start;
        middle/=2;
        Sum part1=new Sum(tablica, this.start, middle);
        Sum part2=new Sum(tablica, middle+1, this.koniec);
        part1.fork(); part2.fork();
        
        suma= part1.join() + part2.join();
    }
    return suma;
    
}
}
/*
class Gen<T extends TwoD>
{
    T zmienna;
    Gen(T ob){this.zmienna=ob;}
    T get(){return this.zmienna;}
    void set(T ob){this.zmienna=ob;}
    
    public void show()
    {
        System.out.println("X:" + zmienna.x + "\nY:" + zmienna.y);
    }
    
}



*/







  



interface Observer
{
    void powiadom();
}

class Obserwator1 implements Observer
{
    @Override
    public void powiadom()
    {
        System.out.println("Pierwsza implementacja! Obserwator1.");
    }
}

class Obserwator2 implements Observer
{
    @Override
    public void powiadom()
    {
        System.out.println("Druga implementacja! Obserwator2.");
    }
}

class Obserwator3 implements Observer
{
    @Override
    public void powiadom()
    {
        System.out.println("Trzecia implementacja! Obserwator3.");
    }
}


class Podmiot
{
    List<Observer> obserwy;
     Podmiot()
    {
        obserwy=new ArrayList<>();
    }
    public void add(Observer x)
    {
        obserwy.add(x);
    }
    
    public void gazu()
    {
        obserwy.stream().forEach(Observer::powiadom);
    }
    
}





class Insurance
{
    String name;
    public Insurance(String n)
    {
        name=n;
    }
    public String getName()
    {
        return name;
    }
}

class Car
{
    Optional<Insurance> ubezpieczenie;
    public void set(Optional<Insurance> t)
    {
        ubezpieczenie=t;
    }
    public Optional<Insurance> get()
    {
        return this.ubezpieczenie;
    }
}
class Osoba
{
    Optional<Car> auto;
    public void set(Optional<Car> autko)
    {
        auto=autko;
    }
    public Optional<Car> get()
    {
        return this.auto;
    }
}










 public class HelloWorld 
{
     
     
    static <P, Q> List<Q> funkcja(List<P> l, Function<P, Q> lambda)
{
    List<Q> lista=new ArrayList<>();
    for(P x: l)
    {
        lista.add(lambda.apply(x));
    }
    return lista;
}
    
    

    
    
     static <T> List<T> produkcja(Supplier<T> lam)
{
    
    List<T> lista=new ArrayList<>();
    for(int i=0;i<10;i++)
    {
        lista.add(lam.get());
    }
    return lista;
}
     
     
   
    
 
    
    
    
     @interface adnot
     {
         int ilosc() default 99;
         String imie() default "Konrad";
     }
     
     @adnot(ilosc=1, imie="Y")
     void funkcja()
     {
         System.out.println();
     }
     
     /*
     CompletableFuture<Integer> oblicz()
     {
         CompletableFuture<Integer> temp=new CompletableFuture<>();
         new Thread(
         new Runnable()
         {
             @Override public void run()
             {
                 Thread.sleep(1500);
                 temp.complete(2000);
             }
         })
         ).start();
     }*/
     
     static Future<Integer> doSomething()
     {
         System.out.println("Oto jakaś asynchroniczna operacja.");
         CompletableFuture<Integer> compl=new CompletableFuture<>();
         
         
         new Thread(()->
         {
             System.out.println("Asynchroniczność!");
             try
             {
             Thread.sleep(2000);
             }catch(InterruptedException a)
             {
                 System.out.println("Coś poszło źle.");
             }
             
          compl.complete(999);
         }).start();
             return compl;

         
     }
  
     
    
    public static void main(String[] args) throws InterruptedException, ExecutionException
    {
        
        PrintWriter pw= new PrintWriter(System.out, true);
        
                  

        
       
        
       
        
        
        pw.println();
    }
    
        
        
     
}
