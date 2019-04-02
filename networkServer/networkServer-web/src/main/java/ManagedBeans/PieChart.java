package ManagedBeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.PieChartModel;

@ManagedBean(name="piebean")
@SessionScoped
public class PieChart {
	
	private PieChartModel model;

	@PostConstruct
	public void init() {
		createPieModels();
	}

	public void createPieModels() {
		model = new PieChartModel();
		model.set("Brand 1", 540);
		model.set("Brand 2", 325);
		model.set("Brand 3", 702);
		model.setTitle("Custom Pie");
		model.setLegendPosition("e");
		model.setFill(false);
    	model.setShowDataLabels(true);
    	model.setDiameter(150);
}

	public void setModel(PieChartModel model) {
		this.model = model;
	}

	public PieChartModel getModel() {
		return model;
	}
}