package com.learning.portal.common;

import java.util.ArrayList;
import java.util.List;

import com.learning.portal.configuration.TaxConfig;
import com.learning.portal.dto.PriceDTO;
import com.learning.portal.model.CoursePrice;

/**
 * @author ravi
 * Utility methods to be placed here for portal
 */
public class PortalUtil {

	public static List<PriceDTO> getPriceDTOList(List<CoursePrice> priceList, TaxConfig config) {
		List<PriceDTO> list = new ArrayList<PriceDTO>();
		for (CoursePrice price : priceList) {
			list.add(new PriceDTO(price, config));
		}
		return list;
	}
}
