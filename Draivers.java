public class Draivers {
    private String  name;
    private Double dilay;
    private Double breaking;
    private String  manuf;

    private Double acceleration;
    private  Double maxSpeed;
    public Draivers(){
        this.name="name";
        this.dilay=0.0;
        this.breaking=0.0;
        this.manuf="manuf";
        this.acceleration=0.0;
        this.maxSpeed=0.0;
    }

    public Draivers(String name,Double dilay,Double breaking,String manuf,Double acceleration,Double maxSpeed){
        this.name=name;
        this.dilay=dilay;
        this.breaking=breaking;
        this.manuf=manuf;
        this.acceleration=acceleration;
        this.maxSpeed=maxSpeed;
    }
    public String getName(){
        return this.name;
    }
    public Double getDilay(){
        return this.dilay;
    }
    public Double getBreaking(){
        return this.breaking;
    }
    public String getmanuf(){
        return this.manuf;
    }
    public Double getAcceleration(){
        return this.acceleration;
    }
    public Double getMaxSpeed(){
        return this.maxSpeed;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setDilay(Double dilay){
        this.dilay=dilay;
    }
    public void setBreaking(Double breaking){
         this.breaking=breaking;
    }
    public void setmanuf(String manuf){
         this.manuf=manuf;
    }
    public void setAcceleration(Double acceleration){
        this.acceleration=acceleration;
    }
    public void setMaxSpeed(Double maxSpeed){
        this.maxSpeed=maxSpeed;
    }

}
