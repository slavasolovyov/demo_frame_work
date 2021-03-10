package Pages;

import Utils.Log;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.*;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class ReportCollector extends SelenideControl{

    private Log log =new Log();

    private SelenideElement totalGroup1 = $x("//h3[text()='Filter counts: Group1']/ancestor::div[@class='gadget color1']" +
            "//header[text()='Total']/..//span[@class='filter-render-view-number']");
    private SelenideElement totalGroup2 = $x("//h3[text()='Filter counts: Group2']/ancestor::div[@class='gadget color1']" +
            "//header[text()='Total']/..//span[@class='filter-render-view-number']");
    private SelenideElement totalGroup3 = $x("//h3[text()='Filter counts: Group3']/ancestor::div[@class='gadget color1']" +
            "//header[text()='Total']/..//span[@class='filter-render-view-number']");
    private ElementsCollection doneByUserCollection = $$(byXpath("//tr[contains(@id,'issuerow')]/td[@class='assignee']//a[@class='user-hover']"));
    private ElementsCollection statusCollection = $$(".jira-issue-status-lozenge");


   private Map<String, String> resultCollector(){
       Map<String, String> map = new HashMap<>();
       map.put("TotalGroup1",getText(totalGroup1));
       map.put("TotalGroup2",getText(totalGroup2));
       map.put("TotalGroup3",getText(totalGroup3));
       return map;
   }

   private List<String> getStatus(ElementsCollection elements, SelenideElement grouplocator){
       List<String> list = new ArrayList<>();
       for (SelenideElement e: elements){
           list.add(getText(e));
       }
       return list;
   }

   private List<String> getDoneBy(SelenideElement group){
       navigateToIssuePage(group);
       List<String> status = getStatus(statusCollection, totalGroup2);
       List<String> userList = getStatus(doneByUserCollection,totalGroup2);
       List<String> result = new ArrayList<>();
       for (int i=0;i<doneByUserCollection.size(); i++){
           if(!(userList.size() == 0))
               result.add(userList.get(i) + " - " + status.get(i));
       }
       return result;
   }

   public void getReport(){
       System.out.println("===================="+"\n"+
               "Group1 done " + resultCollector().get("TotalGroup1") +"\n"+
               "Group2 done " + resultCollector().get("TotalGroup2")+"\n"+
               "Group3 done " + resultCollector().get("TotalGroup3")+"\n"+
               "===================="+"\n");
               getDoneBy(totalGroup2).stream().forEach(System.out::println);
    }

    private void navigateToIssuePage(SelenideElement element){
       selClick(element);
    }
}

