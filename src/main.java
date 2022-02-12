import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class main extends JFrame{
    public static void main(String[] args){
        String[] first_name = new String[] {"Jame","Katie","Carl","Yunko","Mickle","Roger","Janis","Richard"};
        String[] last_name = new String[]{"Smith","Smite","Unic","Aligo","Richkon","Inost","Globe","Oue","Watson","Holmes","Perfect"};
        String[] sex = new String[] {"man","female"};
        String[] name_dog = new String[] {"Lordik","Mars","Graf","Rex","Rorik","Lazu"};
        String[] department_name = new  String[] {"Personnel Analysis Department","Personnel Development Department","Library","Personnel Marketing Department","Museum","Recruitment and Accounting Department"};
        String[] position= new String[] {"Position1","Position2","Position3","Position4","Position5"};
        List<Worker> workers = new ArrayList<Worker>();
        Random random = new Random();
        for (int i=0; i<20;i++) {
            int style = random.nextInt(4);
            switch (style) {
                case 0:
                    workers.add(new Worker(first_name[random.nextInt(8)], last_name[random.nextInt(11)], random.ints(25, 70).findFirst().getAsInt(), sex[random.nextInt(2)], department_name[random.nextInt(6)], position[random.nextInt(5)], random.ints(15000, 80001).findFirst().getAsInt(), random.nextInt(7)));
                    break;
                case 1:
                    workers.add(new Worker(first_name[random.nextInt(8)], last_name[random.nextInt(11)], random.ints(25, 70).findFirst().getAsInt(), sex[random.nextInt(2)],name_dog[random.nextInt(6)], department_name[random.nextInt(6)], position[random.nextInt(5)], random.ints(15000, 80001).findFirst().getAsInt(), random.nextInt(7)));
                    break;
                case 2:
                    workers.add(new Worker(first_name[random.nextInt(8)], last_name[random.nextInt(11)], random.ints(25, 70).findFirst().getAsInt(), sex[random.nextInt(2)], department_name[random.nextInt(6)], position[random.nextInt(5)], random.ints(15000, 80001).findFirst().getAsInt(), random.ints(10000, 40000).findFirst().getAsInt(), random.nextInt(7)));
                    break;
                case 3:
                    workers.add(new Worker(first_name[random.nextInt(8)], last_name[random.nextInt(11)], random.ints(25, 70).findFirst().getAsInt(), sex[random.nextInt(2)], name_dog[random.nextInt(6)], department_name[random.nextInt(6)], position[random.nextInt(5)], random.ints(15000, 80001).findFirst().getAsInt(), random.ints(10000, 40000).findFirst().getAsInt(), random.nextInt(7)));
                    break;
            }
        }
        System.out.println("Максимальная зарплата у: \n"+(workers.stream().max((o1, o2) -> o1.salary- o2.salary)).get().WorkerInformation());
        System.out.println("Минимальная зарплата у:\n\n"+(workers.stream().min((o1,o2)-> o1.salary- o2.salary)).get().WorkerInformation()+"\nВозраст меньше 50 и наличие собаки: \n");
        workers.stream().sorted((o1, o2) -> o1.age - o2.age).filter(x->x.name_dog!="No" && x.age<50).forEach(x -> System.out.println(x.WorkerInformation()));
        System.out.println("\nВозраст больше 50 и наличие собаки: \n\n");
        workers.stream().sorted((o1, o2) -> o1.age - o2.age).filter(x->x.name_dog!="No" && x.age>50).forEach(x -> System.out.println(x.WorkerInformation()));
        String random_depart = department_name[random.nextInt(6)];
        System.out.println("\nСотрудники одного отдела с увеличенной премией(если она больше 0): \n\n");
        workers.stream().filter(x->x.department_name == random_depart).peek(x->x.increasePrize(2)).forEach(x->System.out.println(x.WorkerInformation()));
        System.out.println("\nЧто за сотрудник и компания: ");
        Optional<Worker> worker = workers.stream().filter(x->(x.salary+x.prize)>=100000).findAny();
        if(worker.isPresent()){
            worker.stream().forEach(x->System.out.println(x.WorkerInformation()+"\n"+(x.prize+x.salary)+" наносек"));
        }
        else{
            System.out.println("Компания нищебродов");
        }
        String[] columnnames= new String[]{"Department of Name","Numbers of employees"};
        String[][] department = {
                {"Personnel Analysis Department",String.format("%s",workers.stream().filter(x->x.department_name=="Personnel Analysis Department").count())},
                {"Personnel Development Department",String.format("%s",workers.stream().filter(x->x.department_name=="Personnel Development Department").count())},
                {"Library",String.format("%s",workers.stream().filter(x->x.department_name=="Library").count())},
                {"Personnel Marketing Department",String.format("%s",workers.stream().filter(x->x.department_name=="Personnel Marketing Department").count())},
                {"Museum",String.format("%s",workers.stream().filter(x->x.department_name=="Museum").count())},
                {"Recruitment and Accounting Department",String.format("%s",workers.stream().filter(x->x.department_name=="Recruitment and Accounting Department").count())}
        };
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                new TestFrame(department,columnnames);
            }
        });
    }
}
