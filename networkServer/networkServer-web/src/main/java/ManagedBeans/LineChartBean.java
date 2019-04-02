package ManagedBeans;



import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;


@ManagedBean(name="linechartbean")
@SessionScoped
public class LineChartBean {
	
	
	
	private LineChartModel linemodel;
	
	
    public LineChartModel getLineChartModel() {
		return linemodel;
	}
    
    
	public void setLineChartModel(LineChartModel lineChartModel) {
		this.linemodel = lineChartModel;
	}
	
	
	
	
	
    public LineChartBean () {
        createLineModel();
    }
    @PostConstruct
    public void init() {
        createLineModel();
    }
    
    
    public void createLineModel() {
    	linemodel = new LineChartModel();
        LineChartSeries series1 = new LineChartSeries();

        series1.set(1, 5.20);
        series1.set(2, 19.63);
        series1.set(3, 59.01);
        series1.set(4, 139.76);
        series1.set(5, 300.4);
        series1.set(6, 630);
        
        
        
        linemodel.addSeries(series1);
        linemodel.setTitle("Linear Chart");
        linemodel.setLegendPosition("e");
        
        
        
        Axis yAxis = linemodel.getAxis(AxisType.Y);
        yAxis.setMin(0.5);
        yAxis.setMax(700);
        yAxis.setLabel("Millions");

        Axis x = linemodel.getAxis(AxisType.X);
        x.setMin(0);
        x.setMax(7);
        x.setTickInterval("1");
        x.setLabel("Number of Years");
    }
    

    public LineChartModel getLineModel() {
        return linemodel;
    }
    public void setLineModel(LineChartModel lineModel) {
        this.linemodel = lineModel;
    }
}
