package Tests.kp;

class Test1 {
    static  int multiplyNumber(int numA, int numB, int numC)
    {
        int result,min,max,mid;
        max=(numA>numB)?((numA>numC)?numA:numC):(numB>numC)?numB:numC;
        min=(numA<numB)?((numA<numC)?numA:numC):((numB<numC)?numB:numC);
        mid=(numA+numB+numC)-(min+max);
        result=(max*(int) mid);
        return result;
    }

    public static void main(String[] args) {
        multiplyNumber(1,2,3);
    }
}