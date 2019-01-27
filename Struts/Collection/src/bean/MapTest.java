package bean;

import java.util.*;
import java.util.Map.Entry;

class MapTest
{
public static void main(String ar[])
{
HashMap hs=new HashMap();
hs.put("Aman","Programmer");
hs.put("Aitya","Manager");
hs.put("Sacin","Team Leader");
hs.put("ravi","Trainner");
hs.put("Swarnim","Project manager");
hs.put("Sachin","Programmer");
hs.put("Sachina","Programmer");

System.out.println("There are "+hs.size()+" elements in the hash map...");
System.out.println("Contents of Hash Set...");
Set s=hs.entrySet();
Iterator itr=s.iterator();
while(itr.hasNext())
{
Map.Entry m=(Map.Entry)itr.next();
System.out.println(m.getKey()+"\t"+m.getValue());

}
}
}
