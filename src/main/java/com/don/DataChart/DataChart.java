package com.don.DataChart;

import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.DefaultOHLCDataset;
import org.jfree.data.xy.OHLCDataItem;

import com.don.DataParser.Ohlcv;

public class DataChart {

	 public static void renderChart(String symbol, OutputStream stream, List<Ohlcv> candles) throws Exception {

		 long stocksize = candles.size();
		 OHLCDataItem[] candleSeries = new OHLCDataItem[(int) stocksize];
		 DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd"); 
		 
		 for( int i=0; i<stocksize; i++) {
			 
			 Ohlcv candle = candles.get(i);
			 candleSeries[i] = new OHLCDataItem( candle.getTime(),
				 candle.getOpen(),
				 candle.getHigh(),
				 candle.getLow(),
				 candle.getClose(),
				 candle.getVolume());
		 }
		 DefaultOHLCDataset dataset = new DefaultOHLCDataset(symbol, candleSeries);
		 JFreeChart chart = ChartFactory.createHighLowChart(symbol, "Daily chart", "prices", dataset, true);
		 ChartUtilities.writeChartAsPNG(stream, chart, 500, 500);
	}
}
