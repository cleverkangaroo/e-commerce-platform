package com.kangaroo.microservices.provider.base.web;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kangaroo.microservices.api.base.model.vo.DirectorVO;
import com.kangaroo.microservices.api.base.model.vo.ImageVO;
import com.kangaroo.microservices.api.base.model.vo.SubjectVO;
import com.kangaroo.microservices.api.base.model.vo.UsersVO;
import com.kangaroo.microservices.provider.base.model.entity.Users;
import com.kangaroo.utils.bean.BeanCastUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"电影"})
@RestController("MovieProvider")
@RequestMapping("/movie")
public class MovieProvider {
	
	    @ApiOperation(value = "获取电影列表")
	    @GetMapping("/list")
	    public ResponseEntity<?> list(@RequestParam String type) {
	        List<SubjectVO> list=new ArrayList<SubjectVO>();
	        ImageVO images=null;
	        SubjectVO subjectVO=null;
	        if ("in_theaters".equals(type)) {
	        	 images=new ImageVO("", "", "https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2388501883.jpg");
	        	 subjectVO = new SubjectVO("26630781", "我不是潘金莲", "111");
	        	 subjectVO.setImages(images);
				list.add(subjectVO);
				subjectVO = new SubjectVO("3025375", "奇异博士", "222");
				images=new ImageVO();
				images.setLarge("https://img3.doubanio.com/img/celebrity/large/39703.jpg");
				subjectVO.setImages(images);
			    list.add(subjectVO);
	        }else {
	        	subjectVO = new SubjectVO("26630781", "我不是潘金莲2","333" );
				images=new ImageVO("", "", "https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2388501883.jpg");
				subjectVO.setImages(images);
	        	list.add(subjectVO);
	        	subjectVO = new SubjectVO("3025375", "奇异博士2", "444");
	        	images=new ImageVO();
				images.setLarge("https://img3.doubanio.com/img/celebrity/large/1691.jpg");
	        	subjectVO.setImages(images);
				list.add(subjectVO);
			}
	        return ResponseEntity.ok(list);
	    }
	    
	    @ApiOperation(value = "获取电影详情")
	    @GetMapping("/detail")
	    public ResponseEntity<?> detail(@RequestParam String id) {
	        Map<String, SubjectVO> map=new HashMap<String, SubjectVO>();
	        SubjectVO subjectVO = new SubjectVO("26630781", "我不是潘金莲", "111");
	        ImageVO images=new ImageVO("", "", "https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2388501883.jpg");
	        ImageVO avatars=new ImageVO();
	        avatars.setLarge("https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png");
	        DirectorVO directorVO=new DirectorVO("1332523", "马蒂亚斯·霍恩", avatars);
	        subjectVO.setDirectors(Arrays.asList(directorVO));
	        subjectVO.setImages(images);
	        
	        map.put("26630781", subjectVO);
	        subjectVO=new SubjectVO("3025375", "奇异博士", "222");
	        images=new ImageVO("", "", "https://img3.doubanio.com/img/celebrity/large/39703.jpg");
	        avatars=new ImageVO();
	        avatars.setLarge("https://img3.doubanio.com/img/celebrity/large/1429752266.85.jpg");
	        directorVO=new DirectorVO("1252786", "尤赖亚·谢尔顿恩", avatars);
	        subjectVO.setDirectors(Arrays.asList(directorVO));
	        subjectVO.setImages(images);
	        map.put("3025375", subjectVO);
	        subjectVO= new SubjectVO("26630781", "我不是潘金莲2", "333");
	        images=new ImageVO("", "", "https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2388501883.jpg");
	        avatars=new ImageVO();
	        avatars.setLarge("https://img3.doubanio.com/img/celebrity/large/1429752266.85.jpg");
	        directorVO=new DirectorVO("1252786", "尤赖亚·谢尔顿恩", avatars);
	        subjectVO.setDirectors(Arrays.asList(directorVO));
	        subjectVO.setImages(images);
	        map.put("3025375",subjectVO);
	        subjectVO=new SubjectVO("3025375", "奇异博士2", "444");
	        images=new ImageVO("", "", "https://img3.doubanio.com/img/celebrity/large/1691.jpg");
	        avatars=new ImageVO();
	        avatars.setLarge("https://img3.doubanio.com/img/celebrity/large/1429752266.85.jpg");
	        directorVO=new DirectorVO("1252786", "尤赖亚·谢尔顿恩", avatars);
	        subjectVO.setDirectors(Arrays.asList(directorVO));
	        subjectVO.setImages(images);
	        map.put("3025375", subjectVO);
	        return ResponseEntity.ok(map.get(id));
	    }

}
