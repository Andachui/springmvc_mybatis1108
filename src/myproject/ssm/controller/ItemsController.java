package myproject.ssm.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.aop.aspectj.annotation.LazySingletonAspectInstanceFactoryDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import myproject.ssm.controller.validation.ValidationGroup1;
import myproject.ssm.po.ItemsCustom;
import myproject.ssm.po.ItemsQueryVo;
import myproject.ssm.service.impl.ItemsService;

//为了对url进行分类管理 ，可以在这里定义根路径，最终访问url是根路径+子路径
//比如：商品列表：/items/queryItems.action
@Controller
@RequestMapping("/items")
public class ItemsController {
	@Autowired
	private ItemsService itemsService;
	
	//itemtypes表示最终将方法返回值放在request中的key
	@ModelAttribute("itemtypes")
	public Map<String, String> getItemTypes(){
		Map<String, String> itemTypes=new HashMap<String, String>();
		itemTypes.put("101", "数码");
		itemTypes.put("102", "母婴");
		return itemTypes;
	}
	
	//商品查询
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(ItemsQueryVo itemsQueryVo) throws Exception{
		List<ItemsCustom> itemsList=itemsService.findItemsList(itemsQueryVo);
		ModelAndView modelandView=new ModelAndView();
		modelandView.addObject("itemsList", itemsList);
		modelandView.setViewName("items/itemsList");
		return modelandView;
	}
	
	@RequestMapping("/editItems")
	public String editItems(Model model,Integer id) throws Exception{
		ItemsCustom itemsCustom=itemsService.findItemsById(id);
		//ModelAndView modelandView=new ModelAndView();
		model.addAttribute("itemsCustom", itemsCustom);
		//modelandView.addObject("itemsCustom", itemsCustom);
		//modelandView.setViewName("items/editItems");
		return "items/editItems";
	}
	
	@RequestMapping("/editItemsSubmit")
	//@Validated和BindingResult一前一后配对出现
	//value= {ValidationGroup1.class}指定用分组1的校验
	//ModelAttribute("itemsCustom")指定回显的用itemsCustom这个名字调用，不设置的话默认是回显调用与pojo同名
	public String editItemsSubmit(Model model,Integer id,
			@ModelAttribute("itemsCustom") 
			@Validated(value= {ValidationGroup1.class}) 
			ItemsQueryVo itemsQueryVo,BindingResult bindingResult,
			MultipartFile items_pic)
					throws Exception{
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			return "items/editItems";
		}
		String orginalFilename=items_pic.getOriginalFilename();
		if(items_pic!=null&&orginalFilename!=null&&orginalFilename.length()>0) {
			String pic_path="G:\\java\\eclip\\upload\\";
			String newfilename=UUID.randomUUID()+orginalFilename.substring(orginalFilename.lastIndexOf("."));
			File newFile=new File(pic_path+newfilename);
			items_pic.transferTo(newFile);
			itemsQueryVo.getItemsCustom().setPic(newfilename);
		}
		itemsService.updateItems(id, itemsQueryVo);
		return "success";
	}
	
	@RequestMapping("/deleteItems")
	public String deleteItems(int[] items_id) throws Exception{
		return "success";
	}
	
	@RequestMapping("/editItemsQuery")
	public ModelAndView editItemsQuery(ItemsQueryVo itemsQueryVo) throws Exception{
		List<ItemsCustom> itemsList=itemsService.findItemsList(itemsQueryVo);
		ModelAndView modelandView=new ModelAndView();
		modelandView.addObject("itemsList", itemsList);
		modelandView.setViewName("items/editItemsQuery");
		return modelandView;
	}
	
	@RequestMapping("editItemsAllSubmit")
	//把信息都存到vo的list里
	public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo) throws Exception{
		 
		return "success";
		
	}
	
	//restful支持
	@RequestMapping("/itemsView/{id}")
	public @ResponseBody ItemsCustom itemsView(@PathVariable("id") Integer id) throws Exception {
		ItemsCustom itemsCustom=itemsService.findItemsById(id);
		return itemsCustom;
	}
	
}
