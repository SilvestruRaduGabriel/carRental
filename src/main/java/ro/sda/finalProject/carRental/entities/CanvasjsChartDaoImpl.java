package ro.sda.finalProject.carRental.entities;

import org.springframework.stereotype.Service;
import ro.sda.finalProject.carRental.service.CanvasjsChartData;

@Service
public class CanvasjsChartDaoImpl implements CanvasjsChartDao {
	
	@Override
	public String getCanvasjsChartData() {
		return CanvasjsChartData.getCanvasjsDataList();
	}
 
}           