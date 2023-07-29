import java.util.*;
class DisplayContent{
    private int a[];
    private int size;
    private int capacity;
    static final int initialCapacity=3;

    DisplayContent()
    {
        size=0;
        a = new int[initialCapacity];
        capacity=initialCapacity;
    }
    private void expandArray()
    {
        capacity*=2;   // extend the size of array
        a=java.util.Arrays.copyOf(a, capacity);
        System.out.println(capacity);
    }
    private void shrinkArray()
    {
        capacity /=2;
        a=java.util.Arrays.copyOf(a, capacity);
    }
    void add(int v)
    {
        if(size==capacity)
        {
            expandArray();
        }
         a[size++]=v;   //size when you insert element  
    }
    void display()
    {
        System.out.println("Elements int the list: ");
        for(int i=0;i<size;i++)
        {
            
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    void inserting(int pos,int v)
    {
        if(size==capacity)
        {
            expandArray();
        }
        for(int i=size-1;i>=pos;i--)
        {
            a[i+1]=a[i];
        }
        a[pos]=v;
        size++;
        System.out.println("Array Updated");
    }
    void DeletePos(int pos)
   {
       for(int i=pos+1;i<size;i++)
       {
        a[i-1]=a[i];
       }
       size--;
       if(capacity>initialCapacity && capacity>capacity*3)
       shrinkArray();
   }
   void updateElement(int v,int pos)
   {
    if(pos<=size)
    {
       a[pos]=v;
       System.out.println("Updated!...");
    }
    else System.out.println("Array out of index");   
   }
   void insertBeg(int v)
   {
      size++;
      if(size==capacity)
      {  
        expandArray();
      }
      for(int i=size;i>0;i--)
      {
        a[i]=a[i-1];   //a[4]=a[3]
      }
      a[0]=v;
     
   }
   void deleteBeg()
   {
     
      for(int i=0;i<size-1;i++)
      {
        a[i]=a[i+1];   //a[4]=a[3]
      }
      size--;
      if(capacity>initialCapacity && capacity>3*capacity)
      shrinkArray();
      
   }
   void Search(int v)
   {
      for(int i=0;i<size;i++)
      {
        if(v==a[i])
        {
            System.out.println("The index value is "+i);
        }
      }
   }
   void deleteEnd()
   {
      size--;
   }
}
public class Menu {
  public static void main(String[] args)
    {
        int value,position;
        DisplayContent list=new DisplayContent();
        Scanner sc=new Scanner(System.in);
        while(true)
        {
        System.out.println("choice 1 : Adding elements at the end of an arrays");
        System.out.println("choice 2 : Update element");
        System.out.println("choice 3 : Displaying elements of the array");
        System.out.println("choice 4 : Insert at position");
        System.out.println("choice 5 : Delete from a position");
        System.out.println("choice 6 : Insert at the beginning ");
        System.out.println("choice 7 : Delete at the beginning ");
        System.out.println("choice 8 : Search for a variable index");
        System.out.println("choice 9 : Delete at end");
        System.out.println("choice 10 : Exit");
        System.out.println("Enter your choice: ");
        int choice=sc.nextInt();
        switch (choice) {
            case 1: 
                System.out.println("Enter the value: ");
                value=sc.nextInt(); 
                list.add(value);
                break;
            case 2:
                System.out.println("Enter the value: "); 
                value=sc.nextInt(); 
                System.out.println("Enter the Position: ");
                position=sc.nextInt();
                list.updateElement(value,position);
                break;
            case 3: 
               list.display();
                break;
            case 4:
               System.out.println("Enter the value: ");
               value=sc.nextInt();
                System.out.println("Enter position: ");
                position=sc.nextInt();
                list.inserting(position,value);
                break;
            case 5:
                System.out.println("Enter position: ");
                position=sc.nextInt();
                list.DeletePos(position);
                break;
            case 6:
                System.out.println("Enter value: ");
                value=sc.nextInt();
                list.insertBeg(value);
                break;
            case 7:
               list.deleteBeg();
                break;
            case 8:
               System.out.println("Enter the value");
               value=sc.nextInt();
               list.Search(value);
                break;
            case 9:
               list.deleteEnd();
                break;
            case 10:
                System.exit(0);
                break;
            default: System.out.println("Invalid choice");
                break;
        }
    }
    }
}
