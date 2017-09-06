package java21Day;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/** 
 * @Title: ParseXML 
 * @Description: 根据filepath加载xml,生成Document对象
 * @CreateDate 2017年3月31日 下午4:47:11  
 */
public class ParseXML {
	private String filePath;
	private Document document;
	public ParseXML(String filePath){
		this.filePath =  filePath;
		this.load(filePath);
	}
	/** 
	 * @MethodName: load 
	 * @Description: 加载xml文件为document对象
	 * @Parameter: @param filePath
	 * 得到的Document对象就带表了整个XML
	 */
	private void load(String filePath){
		File file = new File(filePath);
		if(file.exists()){
			SAXReader saxReader = new SAXReader();
			try{
				document = saxReader.read(file);
			}catch(DocumentException e){
				e.printStackTrace();
			}
		}else{
			System.out.println("文件不存在");
		}
	}
	/** 
	 * @MethodName: getElementObject 
	 * @Description:用xpath得到一个元素对象的节点，elementPath是一个xpath绝对路径
	 * @Parameter: @param elementPath
	 * @return 返回一个节点Element对象
	 */
	public Element getElementObject(String elementPath){
		return (Element) document.selectSingleNode(elementPath);
	}
	/** 
	 * @MethodName: getElementObjects
	 * @Description:用xpath得到一组元素对象的节点
	 */
	@SuppressWarnings("unchecked")
	public List<Element> getElementObjects(String elementPath){
		return document.selectNodes(elementPath);
	}
	/** 
	 * @MethodName: etChildrenInfoByElement
	 * @Description:根据获取的element来回去该节点下的所有子节点信息
	 * 节点名称为getName，节点文本为getText
	 */
	@SuppressWarnings("unchecked")
	public Map<String,String> getChildrenInfoByElement(Element element){
			Map<String,String> map = new HashMap<String,String>();
			List<Element> list = element.elements();
			for(Element e:list){
				map.put(e.getName(), e.getText());
			}
			return map;
		}
	//用xpath判断节点对象是否存在
	public boolean isExist(String elementPath){
		boolean flag = false;
		if(this.getElementObject(elementPath)!=null){
			flag = true;
		}
		return flag;
	}
	//用xpath判断节点对象的值
	public String getElementText(String elementPath){
		if(this.getElementObject(elementPath)!=null){
			return(this.getElementObject(elementPath).getText().trim());
		}else{
			return null;
		}
	}
	
	public static void main(String[] args){
		String filePath = "config/TestBaidu.xml";
		String elementPath = "/*/testUI";
		ParseXML px = new ParseXML(filePath);
		px.load(filePath);
		List<Element> list = px.getElementObjects(elementPath);
		Object[][] object = new Object[list.size()][];
		for(int i=0;i<list.size();i++){
			Object[] ob = new Object[]{px.getChildrenInfoByElement(list.get(i))};
			object[i] = ob;
		}
	}
}


/*import java.util.List;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
public class Dom4jXpath {

    public static void main(String[] args) throws Exception {
        select();//查询所有name的值
        //select2();//查询id=stu1的学生的name的值
    }
    //查询所有name的值
    private static void select() throws Exception {
        SAXReader saxReader=new SAXReader();
        Document document=saxReader.read("src/1.xml");
        List<Node>list=document.selectNodes("//name");
        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i).getText());
    }
    //查询id=stu1的学生的name的值
    private static void select2() throws Exception {
        SAXReader saxReader=new SAXReader();
        Document document=saxReader.read("src/1.xml");
        Node node=document.selectSingleNode("//student[@id='stu1']/name");
        System.out.println(node.getText());
    }
 **********************************************************  
    xml文件
    
<?xml version="1.0" encoding="UTF-8"?>

<class> 
  <student> 
    <name>张三</name>  
    <sid>111111</sid> 
  </student>  
  <student id="stu1"> 
    <name>李四</name>  
    <sid>222222</sid> 
  </student> 
</class>


}*/

