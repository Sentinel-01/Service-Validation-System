package Views;

import java.util.ArrayList;

/**
 *  Initialize preprocess
 */
public class Preprocess {
static ArrayList<Preprocess> taskProcess=new ArrayList<Preprocess>(); 
private static String[] arr=new String[3];
	/**
	*  Define preprocess values
	*/
	public void setTask(String task_type,String task_executor,String evidence) {
		
		taskProcess.add(new Preprocess(task_type,task_executor,evidence));
	}
	public  ArrayList<Preprocess> getTask()
	{
		return taskProcess;
	}
	Preprocess(String task_type,String task_executor,String evidence)
	{
		arr[0]=task_type;
		arr[1]=task_executor;
		arr[2]=evidence;
		System.out.println(arr[0]+arr[1]+arr[2]);
	}
	Preprocess()
	{
		
	}
	public  String getTaskType()
	{
		return arr[0];
	}
	public  String getTaskExecutor()
	{
		return arr[1];
	}
	public  String getEvidence()
	{
		return arr[2];
	}
}
