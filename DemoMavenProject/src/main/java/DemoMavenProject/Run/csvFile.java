package DemoMavenProject.Run;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class csvFile {

    private static final String COMMA_DELIMITER = ",";

    private static final String NEW_LINE_SEPARATOR = "\n";

    private static final String FILE_HEADER = "Test,Test,Test";

    private static String filename;

    public csvFile(String file)

    {             
    	this.filename = file;
        File fso;
        FileWriter fw = null;
        BufferedWriter bw = null;
              try
                {

                    fso = new File(filename+".CSV");
                    if(!(fso.exists()))
                       {
                           fso.createNewFile();                                                      
                       }
                                    fw = new FileWriter(fso, true);
                                    bw = new BufferedWriter(fw);
                                    bw.append(FILE_HEADER);
                                    bw.append(COMMA_DELIMITER);
                                    bw.append(NEW_LINE_SEPARATOR);                                    
                                  
                    }catch(Exception ex)

                    {

                      System.out.println("Exception occured while creating CSV file");

                    }finally

                    {

                       try {
                              if (bw != null)
                                   bw.close();
                              if (fw != null)
                                    fw.close();
                            } catch (Exception ex)
                            {
                               ex.printStackTrace();
                            }

                    }

    }
    
    public void insertintoCSVFile(String MenuItemName, String Price, String[] modifiers)

    {                        
                          File fso;
                          FileWriter fw = null;
                          BufferedWriter bw = null;
                          try
                          {
                              //String FILE_HEADER = "MenuItemName,MenuItemDescription,Price";
                               fso = new File(filename+".CSV");
                               fw = new FileWriter(fso, true);
                               bw = new BufferedWriter(fw);
                               //bw.append(FILE_HEADER);
                               bw.append(MenuItemName);
                               bw.append(COMMA_DELIMITER);
                               bw.append(Price);
                               bw.append(COMMA_DELIMITER);
                               for(String element : modifiers)
	                               {
	                            	   bw.append(element);
	                            	   bw.append(COMMA_DELIMITER);
	                               }
                               bw.append(COMMA_DELIMITER);
                               bw.append(NEW_LINE_SEPARATOR);

                          }
                          catch(Exception ex)

                          {

                            System.out.println("Exception occured while inserting into CSV file");

                          }
                          finally
                          {
                               try {
                                                          if (bw != null)
                                                             bw.close();
                                                          if (fw != null)
                                                             fw.close();
                                    }

                               catch (Exception ex)
                                {
                                    ex.printStackTrace();
               
                               	}
                          }
    }
     
}
