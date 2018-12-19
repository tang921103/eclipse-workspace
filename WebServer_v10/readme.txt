本版本改动：
 
 
 重构项目：ClientHandler目前违背了高内聚原则，要进行功能拆分。将业务处理部分抽离出去。
 
 1：创建新的包servlet,这个包中的类负责处理某个具体业务。
 2：在servlet包中定义两个类RegServlet和LoginServlet，分别负责组册与登陆业务。
 3：当ClientHandler根据请求判断为某个业务时，只需要实例化用于处理该业务的Servlet并交由其处理即可。
 4：在servlet中定义所有Servlet的超类HttpServlet。这是一个抽象类，在其中定义所有Servlet都应当具备的功能。
    例如：定义抽象方法service，要求所有Servlet都必须有该方法来处理具体业务。
    再定义一个实现方法forward,用于让具体的Servlet可以跳转指定的页面。
        
 		

 
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	