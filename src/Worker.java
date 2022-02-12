public class Worker {
    public String first_name;
    public  String last_name;
    public int age;
    public String sex;
    public String name_dog = "No";
    public String department_name;
    public String position;
    public int salary;
    public int prize = 0;
    public int years_work;
    Worker(String first_name,String last_name,int age,String sex,String department_name,String position,int salary,int years_work){
        this.first_name=first_name;
        this.last_name=last_name;
        this.age=age;
        this.sex=sex;
        this.department_name=department_name;
        this.position=position;
        this.salary=salary;
        this.years_work=years_work;
    }
    Worker(String first_name,String last_name,int age,String sex,String name_dog,String department_name,String position,int salary,int years_work){
        this.first_name=first_name;
        this.last_name=last_name;
        this.age=age;
        this.sex=sex;
        this.name_dog = name_dog;
        this.department_name=department_name;
        this.position=position;
        this.salary=salary;
        this.years_work=years_work;
    }
    Worker(String first_name,String last_name,int age,String sex,String department_name,String position,int salary,int prize,int years_work){
        this.first_name=first_name;
        this.last_name=last_name;
        this.age=age;
        this.sex=sex;
        this.department_name=department_name;
        this.position=position;
        this.salary=salary;
        this.prize = prize;
        this.years_work=years_work;
    }
    Worker(String first_name,String last_name,int age,String sex,String name_dog,String department_name,String position,int salary,int prize,int years_work){
        this.first_name=first_name;
        this.last_name=last_name;
        this.age=age;
        this.sex=sex;
        this.name_dog=name_dog;
        this.department_name=department_name;
        this.position=position;
        this.salary=salary;
        this.prize = prize;
        this.years_work=years_work;
    }
    public String WorkerInformation(){
        return String.format("Last Name: %s\nFirst Name: %s\nAge: %s\nSex: %s\nName of dog: %s\nName of Department: %s\nPosition: %s\nSalary: %s\nPrize: %s\nYears of Work: %s\n",last_name,first_name,age,sex,name_dog,department_name,position,salary,prize,years_work);
    }
    public String GetSalary(){
        return String.format("Salary: %s\n",salary);
    }
    public void increasePrize(int multy){
        this.prize =  this.prize*multy;
    }
}
