import java.util.Scanner;

public class Complex implements Cloneable, Comparable<Complex>
{
    // The Complex Class:

    // a + bi ; two parts, real and complex

    // attributes
    public double a; // real part
    public double b; // complex part

    // constructors

    // defualt no-arg
    public Complex()
    {
        this.a = 0;
        this.b = 0;
    }

    // real only (complex = 0)
    public Complex(double a)
    {
        this.a = a;
        this.b = 0;
    }

    // full complex number
    public Complex(double a, double b)
    {
        this.a = a;
        this.b = b;
    }


    // behaviors



    // addition method
    public Complex add(Complex o)
    {
        Complex temp = new Complex(a,b);
        Complex temp1 = o;
        double a = temp.getRealPart();
        double b = temp.getImaginaryPart();
        double c = temp1.getRealPart();
        double d = temp1.getImaginaryPart();

        // a + bi + c + di = (a + c) + (b + d)i
        double aNew = a+c;
        double bNew = b+d;
        Complex result = new Complex(aNew, bNew);
        return result;
    }
    // subtraction method
    public Complex subtract(Complex o)
    {
        Complex temp = new Complex(a,b);
        Complex temp1 = o;
        double a = temp.getRealPart();
        double b = temp.getImaginaryPart();
        double c = temp1.getRealPart();
        double d = temp1.getImaginaryPart();

        // a + bi - (c + di) = (a - c) + (b - d)i
        double aNew = a-c;
        double bNew = b-d;
        Complex result = new Complex(aNew, bNew);
        return result;
    }
    // multiplication method
    public Complex multiply(Complex o)
    {
        Complex temp = new Complex(a,b);
        Complex temp1 = o;
        double a = temp.getRealPart();
        double b = temp.getImaginaryPart();
        double c = temp1.getRealPart();
        double d = temp1.getImaginaryPart();

        // (a + bi) * (c + di) = (ac - bd) + (bc + ad)i
        double aNew = (a*c) - (b*d);
        double bNew = (b*c) + (a*d);
        Complex result = new Complex(aNew, bNew);
        return result;
    }
    // division method
    public Complex divide(Complex o)
    {
        Complex temp = new Complex(a,b);
        Complex temp1 = o;
        double a = temp.getRealPart();
        double b = temp.getImaginaryPart();
        double c = temp1.getRealPart();
        double d = temp1.getImaginaryPart();

        // (a+bi)/(c+di) = (ac+bd)/(c^2 +d^2) + (bc-ad)i/(c^2 +d^2)
        double aNew = ((a*c)+(b*d))/((c*c)+(d*d));
        double bNew = ((b*c)-(a*d))/((c*c)+(d*d));
        Complex result = new Complex(aNew, bNew);
        return result;
    }


    // absolute value method aka distance from origin
    public double abs()
    {

        double temp = a;
        double temp1 = b;

        double abs = Math.sqrt((temp*temp)+(temp1*temp1));
        return abs;
    }





    // getRealPart() method
    public double getRealPart()
    {
        return a;
    }

    // getImaginaryPart()

    public double getImaginaryPart()
    {
        return b;
    }

    @Override
    public Complex clone()
    {
        try {
            Complex clone = (Complex) super.clone();
            // copy mutable state here, so the clone can't change the internals of the original
            Complex cloneOfClone = clone;
            return cloneOfClone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public int compareTo(Complex o)
    {
        Complex obj1 = new Complex(a, b);
        Complex obj2 = o;

        double abs1 = obj1.abs();
        double abs2 = obj2.abs();
        // object one equals object 2
        if (abs1 == abs2)
        {
            return 0;
        }
        // object 1 is less than object 2
        else if (abs1 < abs2)
        {
            return -1;
        }
        // object 1 is greater than object 2
        else
        {
            return 1;
        }

    }

    // toString method
    public String toString()
    {
        double a = this.getRealPart();
        String aS = String.valueOf(a);
        double b = this.getImaginaryPart();
        String bS = String.valueOf(b);
        return aS + " + " + bS + "i";
    }

    // Main Method

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first complex number: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        Complex c1 = new Complex(a, b);

        System.out.print("Enter the second complex number: ");
        double c = input.nextDouble();
        double d = input.nextDouble();
        Complex c2 = new Complex(c, d);

        System.out.println("(" + c1 + ")" + " + " + "(" + c2 + ")" + " = " + c1.add(c2));
        System.out.println("(" + c1 + ")" + " - " + "(" + c2 + ")" + " = " + c1.subtract(c2));
        System.out.println("(" + c1 + ")" + " * " + "(" + c2 + ")" + " = " + c1.multiply(c2));
        System.out.println("(" + c1 + ")" + " / " + "(" + c2 + ")" + " = " + c1.divide(c2));
        System.out.println("|" + c1 + "| = " + c1.abs());

        Complex c3 = (Complex)c1.clone();
        System.out.println(c1 == c3);
        System.out.println(c3.getRealPart());
        System.out.println(c3.getImaginaryPart());
        Complex c4 = new Complex(4, -0.5);
        Complex[] list = {c1, c2, c3, c4};
        java.util.Arrays.sort(list);
        System.out.println(java.util.Arrays.toString(list));
    }

}
