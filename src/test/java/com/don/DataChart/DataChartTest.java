package com.don.DataChart;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.don.DataParser.Ohlcv;


public class DataChartTest {
    
	@Test
	public void testApp() throws Exception
    {
		//Date,Open,High,Low,Close,Volume,Adj Close
		//2010-02-02,109.16,109.60,108.61,109.13,14292200,109.13
		//2010-02-01,106.64,108.48,106.37,108.35,14901900,108.35
		
		List<Ohlcv> candles = new ArrayList<Ohlcv>();
		
		Ohlcv candle0 = new Ohlcv();
		candle0.setClose(10870);
		candle0.setOpen(10910);
		candle0.setHigh(10954);
		candle0.setLow(10843);
		candle0.setVolume(13393200);
		candle0.setTime(new Date(1262448120000L));
		candles.add(candle0);
		
		Ohlcv candle1 = new Ohlcv();
		candle1.setClose(10913);
		candle1.setOpen(10915);
		candle1.setHigh(10960);
		candle1.setLow(10861);
		candle1.setVolume(14292200);
		candle1.setTime(new Date(1262361720000L));
		candles.add(candle1);
		
		Ohlcv candle2 = new Ohlcv();
		candle2.setClose(10835);
		candle2.setOpen(10664);
		candle2.setHigh(10848);
		candle2.setLow(10637);
		candle2.setVolume(14901900);
		candle2.setTime(new Date(1262275320000L));
		candles.add(candle2);
		
		OutputStream outstream = new FileOutputStream("./GLD.png");
		DataChart.renderChart("GLD", outstream, candles);
	
    }
}
