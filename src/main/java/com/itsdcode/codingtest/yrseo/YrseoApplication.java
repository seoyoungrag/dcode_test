package com.itsdcode.codingtest.yrseo;

import com.itsdcode.codingtest.yrseo.entity.goods.Goods;
import com.itsdcode.codingtest.yrseo.entity.goods.GoodsSale;
import com.itsdcode.codingtest.yrseo.entity.goods.GoodsSaleShape;
import com.itsdcode.codingtest.yrseo.enums.GoodsCtgry;
import com.itsdcode.codingtest.yrseo.enums.GoodsSaleShapeCl;
import com.itsdcode.codingtest.yrseo.enums.MasterGoodsYn;
import com.itsdcode.codingtest.yrseo.repository.goods.GoodsRepository;
import com.itsdcode.codingtest.yrseo.repository.goods.GoodsSaleRepository;
import com.itsdcode.codingtest.yrseo.repository.goods.GoodsSaleShapeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class YrseoApplication {

	public static void main(String[] args) {
		SpringApplication.run(YrseoApplication.class, args);
	}

	@Bean
	@Transactional
	CommandLineRunner init (GoodsRepository goodsRepository, GoodsSaleRepository goodsSaleRepository, GoodsSaleShapeRepository goodsSaleShapeRepository){
		return args -> {
			//묶음상품 테스트 데이터
			Goods goods1 = new Goods(100000, "상품1", GoodsCtgry.SHOES);
			Goods goods2 = new Goods(25142, "상품2", GoodsCtgry.BAG);
			Goods goods3 = new Goods(51521, "상품3", GoodsCtgry.TSHIRT);
			Goods goods4 = new Goods(41663, "상품4", GoodsCtgry.PANTS);
			Goods goods5 = new Goods(11222, "상품5", GoodsCtgry.HAT);
			Goods goods6 = new Goods(15522, "상품6", GoodsCtgry.RING);
			List<Goods> goodsList = Arrays.asList(new Goods[]{goods1, goods2, goods3, goods4, goods5, goods6});
			GoodsSale goodsSale = new GoodsSale(GoodsSaleShapeCl.BUNDLE);
			GoodsSaleShape goodsSaleShape1 = new GoodsSaleShape(goods1, goodsSale, MasterGoodsYn.YES, 10);
			GoodsSaleShape goodsSaleShape2 = new GoodsSaleShape(goods2, goodsSale, MasterGoodsYn.NO, 20);
			GoodsSaleShape goodsSaleShape3 = new GoodsSaleShape(goods3, goodsSale, MasterGoodsYn.NO, 30);
			GoodsSaleShape goodsSaleShape4 = new GoodsSaleShape(goods4, goodsSale, MasterGoodsYn.NO, 40);
			GoodsSaleShape goodsSaleShape5 = new GoodsSaleShape(goods5, goodsSale, MasterGoodsYn.NO, 50);
			GoodsSaleShape goodsSaleShape6 = new GoodsSaleShape(goods6, goodsSale, MasterGoodsYn.NO, 60);
			List<GoodsSaleShape> goodsSaleShapeList = Arrays.asList(new GoodsSaleShape[]{goodsSaleShape1, goodsSaleShape2, goodsSaleShape3, goodsSaleShape4, goodsSaleShape5, goodsSaleShape6});
			goodsList.forEach(gds -> goodsRepository.save(gds));
			goodsSaleRepository.save(goodsSale);
			goodsSaleShapeList.forEach(gds -> goodsSaleShapeRepository.save(gds));

			//원플러스원 행사 테스트 데이터
			Goods goods7 = new Goods(51522, "상품7", GoodsCtgry.TSHIRT);
			List<Goods> goodsList2 = Arrays.asList(new Goods[]{goods7});
			GoodsSale goodsSale2 = new GoodsSale(GoodsSaleShapeCl.ONE_PLUS_ONE);
			GoodsSaleShape goodsSaleShape7 = new GoodsSaleShape(goods7, goodsSale2, MasterGoodsYn.YES, 0);;
			List<GoodsSaleShape> goodsSaleShapeList2 = Arrays.asList(new GoodsSaleShape[]{goodsSaleShape7});
			goodsList2.forEach(gds -> goodsRepository.save(gds));
			goodsSaleRepository.save(goodsSale2);
			goodsSaleShapeList2.forEach(gds -> goodsSaleShapeRepository.save(gds));

			//옵션구매 테스트 데이터
			Goods goods8 = new Goods(15213, "상품8", GoodsCtgry.SHOES);
			Goods goods9 = new Goods(51522, "상품9", GoodsCtgry.BAG);
			List<Goods> goodsList3 = Arrays.asList(new Goods[]{goods8, goods9});
			GoodsSale goodsSale3 = new GoodsSale(GoodsSaleShapeCl.OPTION);
			GoodsSaleShape goodsSaleShape9 = new GoodsSaleShape(goods8, goodsSale3, MasterGoodsYn.YES, 0);
			GoodsSaleShape goodsSaleShape10 = new GoodsSaleShape(goods9, goodsSale3, MasterGoodsYn.NO, 30);
			List<GoodsSaleShape> goodsSaleShapeList3 = Arrays.asList(new GoodsSaleShape[]{goodsSaleShape9, goodsSaleShape10});
			goodsList3.forEach(gds -> goodsRepository.save(gds));
			goodsSaleRepository.save(goodsSale3);
			goodsSaleShapeList3.forEach(gds -> goodsSaleShapeRepository.save(gds));

			//단품상품 테스트 데이터
			Goods goods10 = new Goods(51555, "상품10", GoodsCtgry.HAT);
			List<Goods> goodsList4 = Arrays.asList(new Goods[]{goods10});
			GoodsSale goodsSale4 = new GoodsSale(GoodsSaleShapeCl.ONE);
			GoodsSaleShape goodsSaleShape11 = new GoodsSaleShape(goods10, goodsSale4, MasterGoodsYn.YES, 0);
			List<GoodsSaleShape> goodsSaleShapeList4 = Arrays.asList(new GoodsSaleShape[]{goodsSaleShape11});
			goodsList4.forEach(gds -> goodsRepository.save(gds));
			goodsSaleRepository.save(goodsSale4);
			goodsSaleShapeList4.forEach(gds -> goodsSaleShapeRepository.save(gds));

		};
	}
}
