package eg.edu.alexu.csd.datastructure.linkedList.cs24_cs28;

public class PolynomialSolver implements IPolynomialSolver {

    SinglyLinkedList A = new SinglyLinkedList();
    SinglyLinkedList B = new SinglyLinkedList();
    SinglyLinkedList C = new SinglyLinkedList();
    SinglyLinkedList R = new SinglyLinkedList();
    SinglyLinkedList var1 ;
    SinglyLinkedList var2 ;
    @Override
    public void setPolynomial(char poly, int[][] terms) {

       if (Character.toUpperCase(poly) == 'A')
           A = arraytolist(terms);
        else if (Character.toUpperCase(poly) == 'B')
            B = arraytolist(terms);
        else if (Character.toUpperCase(poly) == 'C') // return error on else ?
            C = arraytolist(terms);
    }

    @Override
    public String print(char poly) {
        String polynomial = "";
        var1 = sort(EliminateZeroAndRepeated(chooseList(poly)));
            for (int i = 0; i < this.var1.size(); i += 2) {
                if ((int) this.var1.get(i) > 0) {
                    if (i != 0)
                        polynomial = polynomial.concat("+"); // to prevent +X-1
                    if ((int) this.var1.get(i) != 1)
                        polynomial = polynomial.concat(this.var1.get(i).toString()); // to prevent // 1X - 1
                   if ((int) this.var1.get(i)==1 && (int) this.var1.get(i+1)==0)
                    polynomial=polynomial.concat("1");
                } else if ((int) this.var1.get(i) < 0)
                    if ((int) this.var1.get(i) != -1)
                        polynomial = polynomial.concat(this.var1.get(i).toString());
                    else
                        polynomial = polynomial.concat("-");
                if ((int) this.var1.get(i) != 0 && (int) this.var1.get(i+1)!=0) {// to prevent X^0
                    polynomial = polynomial.concat("X");
                    if ((int) this.var1.get(i+1)!=1)
                        polynomial = polynomial.concat("^" + this.var1.get(i + 1).toString()); // to prevent X^1
                }
            }
            if(polynomial.length()==0)
                polynomial=polynomial.concat("0");
        return polynomial;
    }

    @Override
    public void clearPolynomial(char poly) {
        chooseList(poly).clear();
    }

    @Override
    public float evaluatePolynomial(char poly, float value) {
        float result = 0;
            var1 = chooseList(poly);
            for (int i = 0; i < var1.size(); i += 2) {
                result += (int) var1.get(i) * Math.pow(value, (int) (var1.get(i + 1)));
            }
        return result;
    }

    @Override
    public int[][] add(char poly1, char poly2) {
         var1 = chooseList(poly1);
         var2 = chooseList(poly2);
       R.clear();
        int flag ;
        for(int i=1 ; i<var1.size(); i+=2) {
            flag =0 ;
            for(int j=1 ; j<var2.size(); j+=2) {
                if(var1.get(i)==var2.get(j)) {
                    R.add((int)var1.get(i-1) +(int)var2.get(j-1));
                    R.add(var1.get(i));
                    flag =1 ;
                }
            }
            if(flag == 0) {
                R.add(var1.get(i-1));
                R.add(var1.get(i));
            }
        }
        for(int i=1 ; i<var2.size(); i+=2) {
            flag =0 ;
            for(int j=1 ; j<var1.size(); j+=2) {
                if(var2.get(i)==var1.get(j))
                    flag =1 ;
            }
            if(flag == 0) {
                R.add(var2.get(i-1));
                R.add(var2.get(i));
            }
        }
        return listtoarray(sort(EliminateZeroAndRepeated(R)));
    }

    @Override
    public int[][] subtract(char poly1, char poly2) {
        R.clear();
        var1 = chooseList(poly1);
        var2 = chooseList(poly2);
            int flag ;
            for(int i=1 ; i<var1.size(); i+=2) {
                flag =0 ;
                for(int j=1 ; j<var2.size(); j+=2) {
                    if(var1.get(i)==var2.get(j)) {
                        R.add((int)var1.get(i-1) -(int)var2.get(j-1));
                        R.add(var1.get(i));
                        flag =1 ;
                    }
                }
                if(flag == 0) {
                    R.add(var1.get(i-1));
                    R.add(var1.get(i));
                }
            }
            for(int i=1 ; i<var2.size(); i+=2) {
                flag =0 ;
                for(int j=1 ; j<var1.size(); j+=2) {
                    if(var2.get(i)==var1.get(j)) {
                        flag =1 ;
                    }
                }
                if(flag == 0) {
                    R.add(-(int)var2.get(i-1));
                    R.add(var2.get(i));
                }
            }
        return listtoarray(sort(EliminateZeroAndRepeated(R)));
    }

    @Override
    public int[][] multiply(char poly1, char poly2) {
        R.clear();
        var1 = chooseList(poly1);
        var2 = chooseList(poly2);
            for(int i = 0 ;i<var1.size(); i+=2) {
                for(int j=0 ; j<var2.size();j+=2) {
                    R.add((int)var1.get(i) * (int)var2.get(j));
                    R.add((int)var1.get(i+1) + (int)var2.get(j+1));
                }
            }
        return listtoarray(sort(EliminateZeroAndRepeated(R)));
    }

    public SinglyLinkedList arraytolist (int[][] arr)
    {
        SinglyLinkedList mylist = new SinglyLinkedList();
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                mylist.add(ints[j]);
            }
        }
        return mylist;
    }
    public int[][] listtoarray (SinglyLinkedList mylist){
        int[][] myarray = new int [(mylist.size()/2)][2];
        for (int i = 0; i < mylist.size()/2 ; i++) {
            for (int j = 0; j < 2 ; j++) {
                myarray[i][j] = (int)(mylist.get(j+i*2));
            }
        }
        return myarray;
    }
    public SinglyLinkedList sort(SinglyLinkedList list) {
        int temp1;
        int temp2;
        for(int i =1 ; i<list.size() ; i+=2) {
            for(int j =i+2 ; j<list.size() ; j+=2) {
                if((int)list.get(i)<(int)list.get(j)) {
                    temp1 = (int) list.get(i) ;
                    list.set(i, list.get(j));
                    list.set(j,temp1);
                    /////////////////////////////////////
                    temp2 = (int) list.get(i-1) ;
                    list.set(i-1, list.get(j-1));
                    list.set(j-1,temp2);
                }
            }
        }
        return list;
    }
    public SinglyLinkedList chooseList (char poly){
        if (Character.toUpperCase(poly) == 'A')
            return A;
        else if (Character.toUpperCase(poly) == 'B')
            return B;
        else if (Character.toUpperCase(poly) == 'C')
            return C;
        else if (Character.toUpperCase(poly) == 'R') // return error on else ?
            return R;
        return null;
    }
    public SinglyLinkedList EliminateZeroAndRepeated (SinglyLinkedList R){
        for(int i=1 ; i<R.size();i+=2) {             // to eliminate terms with same exponent
            for(int j =i+2 ; j<R.size() ;) {
                if(R.get(i)== R.get(j)) {
                    R.set(i-1,(int) R.get(i-1)+(int)R.get(j-1));
                    R.remove(j-1);
                    R.remove(j-1);
                }
                else j+=2;
            }
        }
        for(int i = 0;i<R.size();) {            // to remove terms with zero coefficient
            if((int)R.get(i)==0) {
                R.remove(i);
                R.remove(i);
            }
            else i+=2;
        }
        if(R.size() == 0){
            R.add(0);
            R.add(0);
        }
        return R;
    }
}
