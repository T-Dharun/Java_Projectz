import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent; // Add import for ActionEvent
import java.awt.event.ActionListener; // Add import for ActionListener

class E_Bill extends Frame{
    E_Bill(){
        Label l1=new Label("Consumer ID");
        TextField id=new TextField();
        Label l2=new Label("Consumer Name");
        TextField name=new TextField();
        Label l3=new Label("Type");
        Choice type=new Choice();
        type.add("Domestic");
        type.add("Industry");
        type.add("Residential");
        Label l4=new Label("Units Consumed");
        TextField unit=new TextField("0");
        Label l5=new Label("Region");
        Choice region=new Choice();
        region.add("Tamilnadu");
        region.add("Kerala");
        region.add("Karnataka");
        region.add("Andrapradesh");
        Button calculate=new Button("Calculate");
        TextArea display=new TextArea();
        Button clear=new Button("Clear");
        Button print=new Button("Print");
        add(l1);
        add(id);
        add(l2);
        add(name);
        add(l3);
        add(type);
        add(l4);
        add(unit);
        add(l5);
        add(region);
        add(calculate);
        add(display);
        add(print);
        add(clear);
        setVisible(true);
        setLayout(null);
        l1.setBounds(20,60,100,20);
        l2.setBounds(20,90,100,20);
        l3.setBounds(20,120,100,20);
        l4.setBounds(20,150,100,20);
        l5.setBounds(20,180,100,20);
        id.setBounds(140,60,120,20);
        name.setBounds(140,90,120,20);
        type.setBounds(140,120,120,20);
        unit.setBounds(140,150,120,20);
        region.setBounds(140,180,120,20);
        calculate.setBounds(140,240,120,30);
        display.setBounds(300,60,200,150);
        clear.setBounds(300,240,70,30);
        print.setBounds(420,240,70,30);
        setTitle("Electricity Bill Generator");
        setSize(550,300);
        Listener Bl=new Listener(unit,display,name,id);
        calculate.addActionListener(Bl);
        ActionListener cl=new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                display.setText("");
                name.setText("");
                id.setText("");
                unit.setText("0");
            }
        };
        clear.addActionListener(cl);
    }
}
class Listener implements ActionListener{
    TextField unit,id,name;
    TextArea area;
    Calculate c=new Calculate();
    Listener(TextField unit,TextArea area,TextField name,TextField id){
        this.unit=unit;
        this.name=name;
        this.id=id;
        this.area=area;
    }
    public void actionPerformed(ActionEvent e){
        String str=unit.getText();
        int u=Integer.parseInt(str);
        double val=c.calculate((double)u);
        area.setText("\n     Welcome to TN EB\n\n     *******************************\n     Consumer ID : "+id.getText()+"\n     Consumer Name : "+name.getText()+"\n\n     Total Price : "+val+"\n\n     *******************************");
        //System.out.println("Seted");
    }
}
class Calculate
{
    double calculate(double Unit)
    {
        double Total=0d,T,Pr;
        if(Unit>1000)
        {
            T=Unit-1000;
            Pr=T*11;
            Total+=Pr;
            Unit=1000;
        }
        if(Unit>800)
        {
            T=Unit-800;
            Pr=T*10;
            Total+=Pr;
            Unit=800;
        }
        if(Unit>600)
        {
            T=Unit-600;
            Pr=T*9;
            Total+=Pr;
            Unit=600;
        }
        if(Unit>500)
        {
            T=Unit-500;
            Pr=T*8;
            Total+=Pr;
            Unit=500;
        }
        if(Unit>400)
        {
            T=Unit-400;
            Pr=T*6;
            Total+=Pr;
            Unit=400;
        }
        if(Unit>200)
        {
            T=Unit-200;
            Pr=T*4.5;
            Total+=Pr;
            Unit=200;
        }
        if(Unit>100)
        {
            T=Unit-100;
            Pr=T*2.25;
            Total+=Pr;
            Unit=100;
        }
        if(Unit>0)
        {
            T=Unit-0;
            Pr=T*0;
            Total+=Pr;
            Unit=0;
        }
        return Total;
    }
}
public class Main{
    public static void main(String args[]){
        new E_Bill();
        System.out.println("Program Executed");
    }
}