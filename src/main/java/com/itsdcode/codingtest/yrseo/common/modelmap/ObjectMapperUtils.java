package com.itsdcode.codingtest.yrseo.common.modelmap;

import org.hibernate.collection.internal.PersistentSet;
import org.modelmapper.Condition;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectMapperUtils {

	private static ModelMapper modelMapper = ObjectMapperUtils.getModelMapper();

	/**
	 * Model mapper property setting are specified in the following block. Default
	 * property matching strategy is set to Strict see {@link MatchingStrategies}
	 * Custom mappings are added using {@link ModelMapper#addMappings(PropertyMap)}
	 */
	static {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
    	.setPropertyCondition(new Condition<Object, Object>() {
  	      public boolean applies(MappingContext<Object, Object> context) {
  	    	  if(context.getSource() instanceof PersistentSet) {
  	    		  try {
  	    			  return !((PersistentSet) context.getSource()).isEmpty();
  	    		  }catch(Exception e) {
  	    			  //영속성 전이가 이루어져 객체가 존재할 경우에만 매핑을 시도한다. PersistentSet이 프록시로 동작하기에 프록시 오브젝트의 에러 타입을 잡아낼 수 가 없다.
  	    			  return false;
  	    		  }
  	    	  }else {
  	    		  return true;
  	    	  }
  	    	  //return !(context.getSource() instanceof PersistentCollection);
  	      }
    	});

	}
	
	/**
	 * Hide from public usage.
	 */
	private ObjectMapperUtils() {
	}

	public static ModelMapper getModelMapper() {
		return modelMapper;
	}
	
	/**
	 * <p>
	 * Note: outClass object must have default constructor with no arguments
	 * </p>
	 *
	 * @param <D>      type of result object.
	 * @param <T>      type of source object to map from.
	 * @param entity   entity that needs to be mapped.
	 * @param outClass class of result object.
	 * @return new object of <code>outClass</code> type.
	 */
	public static <D, T> D map(final T entity, Class<D> outClass) {
		return modelMapper.map(entity, outClass);
	}

	/**
	 * <p>
	 * Note: outClass object must have default constructor with no arguments
	 * </p>
	 *
	 * @param entityList list of entities that needs to be mapped
	 * @param outCLass   class of result list element
	 * @param <D>        type of objects in result list
	 * @param <T>        type of entity in <code>entityList</code>
	 * @return list of mapped object with <code><D></code> type.
	 */
	public static <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
		return entityList.stream().map(entity -> map(entity, outCLass)).collect(Collectors.toList());
	}

	/**
	 * Maps {@code source} to {@code destination}.
	 *
	 * @param source      object to map from
	 * @param destination object to map to
	 */
	public static <S, D> D map(final S source, D destination) {
		modelMapper.map(source, destination);
		return destination;
	}
}
