package service;
/**
 * 模型：
 * 			负责数据处理（即业务逻辑）
 * @author soft01
 *
 */
public class BmiService {
		public String bmi(double height,double weight) {
			String status = "正常";
			double bmi = weight/height/height;
			if(bmi<19) {
				status = "过轻";
			}else if(bmi>25) {
				status = "过重";
			}
			return "你的bmi指数是："+bmi+"  体重"+status;
		}
}
