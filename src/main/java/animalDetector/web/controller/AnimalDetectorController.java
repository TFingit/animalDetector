package animalDetector.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import animalDetector.utils.DetectAnimal;

@RestController
public class AnimalDetectorController {

	@RequestMapping(value="/detect",method=RequestMethod.POST)
	public ModelAndView detectAnimal(MultipartFile animalPic) throws Exception{
		Map<String, String> detectAnimal = DetectAnimal.detectAnimal(animalPic.getInputStream());
		
		String name = detectAnimal.get("name");
		String score = detectAnimal.get("score");
		return new ModelAndView("detect","msg","这是"+name+",相似度为"+score);
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView detectAnimal() throws Exception{
		return new ModelAndView("detect","msg","欢迎进入动物识别页面，请上传一张图片");
		
	}
}
