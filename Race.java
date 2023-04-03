import java.util.Scanner;
public class Race {
    private int numOfRace=0;
    private String [] name;
    private int segments;
    private Double [] arrLength;
    private int numOfdrivers;
    private String [] arryname;
    private Double[] arrybreak;
    private Double[] arrydelay;
    private String [] arrynmanuf;
    private Double[] arryaccel;
    private Double[] arryspeed;

    public Race(){
         numOfdrivers=0;
         segments=0;
         name=new String[numOfdrivers];
         arrLength=new Double[segments];
         arryname=new String[numOfdrivers];
         arrybreak=new Double[segments];
         arrydelay=new Double[segments];
         arrynmanuf=new String[numOfdrivers];
         arryaccel=new Double[segments];
         arryspeed=new Double[segments];
         numOfRace++;
    }

    public void getRouteFromSysIn(){
        Double length;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("How many segments does the route contain ?");
            this.segments = scan.nextInt();
            if(this.segments<=0){
                System.out.println("input must be a positive integer,got"+this.segments);
            }
        }while(this.segments<=0);
         this.arrLength=new Double[segments];
        for(int i=0;i<segments;i++){
            do{
                System.out.println("What is the length of segment"+i+" ?");
                length=scan.nextDouble();
                if(length<=0)
                    System.out.println("input must be a positive double,got"+length);
                else
                    this.arrLength[i]=length;
            }while(length<=0);
        }
    }

    public void getDriversAndCarsFromSysIn(){
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("How many participants are there in the race ?");
            this.numOfdrivers = scan.nextInt();
            if(this.numOfdrivers<=0){
                System.out.println("input must be a positive integer,got"+numOfdrivers);
            }
        }while(this.numOfdrivers<=0);
        this.numOfdrivers=numOfdrivers;
      this.arryname= new String[this.numOfdrivers];
         this.arrybreak=new Double[this.numOfdrivers];
         this.arrydelay=new Double[this.numOfdrivers];
        for(int i=0;i<this.numOfdrivers;i++){
            System.out.println("Please enter details for driver "+i);
            System.out.println("What is the driver's name?");
            this.arryname[i]=scan.nextLine();
            this.arryname[i]=scan.nextLine();
            System.out.println("What is the driver's breakig rate?");
            this.arrybreak[i]=scan.nextDouble();
            System.out.println("What is the driver's delay time?");
            this.arrydelay[i]= scan.nextDouble();
        }

        this.arrynmanuf= new String[this.numOfdrivers];
        this.arryaccel=new Double[this.numOfdrivers];
        this.arryspeed=new Double[this.numOfdrivers];
        for(int i=0;i<numOfdrivers;i++){
            System.out.println("Please enter details for car "+i+":");
            System.out.println("What is the car's manufacturer?");
            arrynmanuf[i]=scan.nextLine();
            arrynmanuf[i]=scan.nextLine();
            System.out.println("What is the car's acceleration?");
            arryaccel[i]=scan.nextDouble();
            System.out.println("What is the car's maximun speed?");
            arryspeed[i]= scan.nextDouble();
        }

    }

    public void runRace() {
        Double [] timeA=new Double[this.numOfdrivers];
        Double [] timeB=new Double[this.numOfdrivers];
        Double [] timeM=new Double[this.numOfdrivers];
        Double [] timeTot=new Double[this.numOfdrivers];
        Double [] distance=new Double[this.numOfdrivers];
        Double win;
        int indexWin=0;
        for(int i=0;i<this.numOfdrivers;i++){//the time of acceleration
            timeA[i]=this.arryspeed[i]/this.arryaccel[i];
            distance[i]=0.5*this.arryaccel[i]*timeA[i]*timeA[i];
        }
        for(int i=0;i<this.numOfdrivers;i++){//the time of breaking
            timeB[i]=this.arryspeed[i]/this.arrybreak[i];
            distance[i]+=0.5*this.arrybreak[i]*timeB[i]*timeB[i];
        }
        for (int i = 0; i < this.numOfdrivers; i++) {//restart the array of time max speed
            timeM[i]=0.0;
        }
        for(int j=0;j<this.segments;j++) {//the time of drive in max speed
            for (int i = 0; i < this.numOfdrivers; i++) {
                timeM[i] += (this.arrLength[j]-distance[i])/this.arryspeed[i];
            }
        }
        for(int i=0;i<this.numOfdrivers;i++){//the total time
            timeTot[i]=this.segments*timeA[i]+this.segments*timeB[i]+timeM[i]+(this.segments-1)*this.arrydelay[i];
        }
        win=timeTot[1];
        for(int i=0;i<this.numOfdrivers;i++){
            System.out.println(this.arryname[i]+", "+this.arrynmanuf[i]+", "+timeTot[i]);
            if(timeTot[i]<=win) {
                win = timeTot[i];
                indexWin = i;
            }
        }
        System.out.println("The winner is: "+this.arryname[indexWin]);


    }

    public void runAllPairsRace() {
        Double [] timeA=new Double[this.numOfdrivers*this.numOfdrivers];
        Double [] timeB=new Double[this.numOfdrivers*this.numOfdrivers];
        Double [] timeM=new Double[this.numOfdrivers*this.numOfdrivers];
        Double [] timeTot=new Double[this.numOfdrivers*this.numOfdrivers];
        Double [] distance=new Double[this.numOfdrivers*this.numOfdrivers];
        Double win;
        int indexWin=0;
        Draivers[] arrDC=new Draivers[this.numOfdrivers*this.numOfdrivers];
        for(int i=0;i<this.numOfdrivers*this.numOfdrivers;i++){
            arrDC[i]=new Draivers();
        }
        int index=0;
        for(int i=0;i<this.numOfdrivers;i++){
            for(int j=0;j<this.numOfdrivers;j++){
                arrDC[index].setName(arryname[i]);
                arrDC[index].setDilay(arrydelay[i]);
                arrDC[index].setBreaking(arrybreak[i]);
                arrDC[index].setmanuf(arrynmanuf[j]);
                arrDC[index].setAcceleration(arryaccel[j]);
                arrDC[index].setMaxSpeed(arryspeed[j]);
                index++;
            }
        }
        for(int i=0;i<this.numOfdrivers*this.numOfdrivers;i++){//the time of acceleration
            timeA[i]=arrDC[i].getMaxSpeed()/arrDC[i].getAcceleration();
            distance[i]=0.5*arrDC[i].getAcceleration()*timeA[i]*timeA[i];
        }
        for(int i=0;i<this.numOfdrivers*this.numOfdrivers;i++){//the time of breaking
            timeB[i]=arrDC[i].getMaxSpeed()/arrDC[i].getBreaking();
            distance[i]+=0.5*arrDC[i].getBreaking()*timeB[i]*timeB[i];
        }
        for (int i = 0; i < this.numOfdrivers*this.numOfdrivers; i++) {//restart the array of time max speed
            timeM[i]=0.0;
        }
        for(int j=0;j<this.segments;j++) {//the time of drive in max speed
            for (int i = 0; i < this.numOfdrivers*this.numOfdrivers; i++) {
                timeM[i] += (this.arrLength[j]-distance[i])/arrDC[i].getMaxSpeed();
            }
        }
        for(int i=0;i<this.numOfdrivers*this.numOfdrivers;i++){//the total time
            timeTot[i]=this.segments*timeA[i]+this.segments*timeB[i]+timeM[i]+(this.segments-1)*arrDC[i].getDilay();
        }
        win=timeTot[1];
        for(int i=0;i<this.numOfdrivers*this.numOfdrivers;i++){
            System.out.println(arrDC[i].getName()+", "+arrDC[i].getmanuf()+", "+timeTot[i]);
            if(timeTot[i]<=win) {
                win = timeTot[i];
                indexWin = i;
            }
        }
        System.out.println("The winner is: "+arrDC[indexWin].getName()+" and "+arrDC[indexWin].getmanuf()+", who completed the race iz  "+timeTot[indexWin]+" swconds");






    }

    public void printTotalInstantiatedRaces() {
      System.out.println("The number of constructedn Race instances is "+numOfRace);
    }

    public void runRaceWithSortedOutput() {
        // A bonus question: same as runRace, with the exception that the list
        // of drivers should be printed with increasing times.

        // TODO: implement here the code question 4 in the assignment. See example
        //  for expected behaviour in the assignment description.
    }

}