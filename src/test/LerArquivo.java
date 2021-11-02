package test;
import static org.junit.Assert.assertEquals;

import exceptions.ArquivoNaoEncontradoException;
import org.junit.Test;
import main.Parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LerArquivo {

	@Test
	public void TesteLerArquivoSucessoAnalysisMemory() throws ArquivoNaoEncontradoException {
		Parser parser = new Parser();
		@SuppressWarnings("serial")
		List<List<Double>> array = new ArrayList<List<Double>>() {{

			add(Arrays.asList(34.63005828857422, 34.62224578857422, 34.62224578857422, 34.62224578857422, 34.62224578857422, 34.62224578857422, 34.62224578857422, 34.62224578857422, 34.62224578857422, 34.62224578857422, 34.62224578857422));
			add(Arrays.asList(35.59007263183594, 35.59007263183594, 35.59007263183594, 35.59007263183594, 35.59007263183594, 35.59007263183594, 35.59007263183594, 35.59007263183594, 35.59007263183594, 35.59007263183594, 35.59007263183594));
			add(Arrays.asList(35.59031677246094, 35.59031677246094, 35.55113220214844, 35.537513732910156, 35.55113220214844, 35.55113220214844, 35.53749084472656, 35.59031677246094, 35.59031677246094, 35.55113220214844, 35.553192138671875));
			add(Arrays.asList(36.65733337402344, 36.65733337402344, 36.65733337402344, 36.65733337402344, 36.65733337402344, 36.65733337402344, 36.65733337402344, 36.65733337402344, 36.65733337402344, 36.65733337402344, 36.65733337402344));
			add(Arrays.asList(37.63884735107422, 37.63884735107422, 37.63884735107422, 37.63884735107422, 37.63884735107422, 37.63884735107422, 37.63884735107422, 37.63884735107422, 37.63884735107422, 37.63884735107422, 37.63884735107422));
			add(Arrays.asList(39.574554443359375, 39.574554443359375, 39.537864685058594, 39.574554443359375, 39.574554443359375, 39.574554443359375, 39.574554443359375, 39.574554443359375, 39.574554443359375, 39.574554443359375, 39.574554443359375));
			add(Arrays.asList(41.617401123046875, 41.617401123046875, 41.617401123046875, 41.617401123046875, 41.617401123046875, 41.617401123046875, 41.617401123046875, 41.617401123046875, 41.617401123046875, 41.617401123046875, 41.617401123046875));
			add(Arrays.asList(41.617401123046875, 41.617401123046875, 41.617401123046875, 41.617401123046875, 41.617401123046875, 41.617401123046875, 41.617401123046875, 41.617401123046875, 41.617401123046875, 41.617401123046875, 41.617401123046875));
			add(Arrays.asList(41.617401123046875, 41.617401123046875, 41.617401123046875, 41.617401123046875, 41.617401123046875, 41.617401123046875, 41.617401123046875, 41.617401123046875, 41.617401123046875, 41.617401123046875, 41.617401123046875));
			add(Arrays.asList(44.65733337402344, 44.65733337402344, 44.65733337402344, 44.65733337402344, 44.65733337402344, 44.65733337402344, 44.65733337402344, 44.65733337402344, 44.65733337402344, 44.65733337402344, 44.65733337402344));
			add(Arrays.asList(49.617401123046875, 49.617401123046875, 49.617401123046875, 49.617401123046875, 49.617401123046875, 49.617401123046875, 49.617401123046875, 49.617401123046875, 49.617401123046875, 49.617401123046875, 49.617401123046875));
			add(Arrays.asList(27.553634643554688, 27.553665161132812, 27.553207397460938, 27.553665161132812, 27.55321502685547, 27.55315399169922, 27.553268432617188, 27.553207397460938, 27.55127716064453, 27.553184509277344, 27.553665161132812));
			add(Arrays.asList(27.53746795654297, 27.537437438964844, 27.53839111328125, 27.537437438964844, 27.537437438964844, 27.53746795654297, 27.53746795654297, 27.53839111328125, 27.537460327148438, 27.53746795654297, 27.537460327148438));
			add(Arrays.asList(46.99834442138672, 47.094459533691406, 47.07793426513672, 46.91382598876953, 47.08573913574219, 47.082122802734375, 47.079925537109375, 47.071144104003906, 46.99921417236328, 47.090492248535156, 46.910987854003906));
			add(Arrays.asList(85.93535614013672, 86.41481018066406, 87.74950408935547, 86.42205810546875, 88.19488525390625, 86.57553100585938, 85.738037109375, 86.074951171875, 86.42327880859375, 86.7900390625, 85.97779083251953));
			add(Arrays.asList(265.6123046875, 275.25634765625, 273.25341796875, 273.697265625, 265.091796875, 266.962890625, 271.42724609375, 265.06201171875, 265.19482421875, 267.552734375, 275.07666015625));
			add(Arrays.asList(619.75732421875, 585.64697265625, 597.697265625, 617.611328125, 611.6953125, 609.8193359375, 588.79931640625, 617.62646484375, 617.7587890625, 613.75927734375, 609.697265625));
			add(Arrays.asList(292.1605224609375, 298.0877914428711, 259.40924072265625, 296.4632568359375, 294.85009765625, 306.47003173828125, 294.8548583984375, 311.5275344848633, 301.19384765625, 294.99249267578125, 288.36924743652344));
			add(Arrays.asList(789.6953125, 1037.697265625, 1525.6953125, 1293.697265625, 1441.6005859375, 805.6953125, 1487.6953125, 1605.6953125, 1397.697265625, 647.6953125, 1433.10009765625));
			add(Arrays.asList(2545.6953125, 2563.697265625, 2507.6953125, 2415.6953125, 2637.697265625, 2477.697265625, 2579.6953125, 2359.697265625, 2575.697265625, 2065.697265625, 2437.6953125));
			add(Arrays.asList(4891.6953125, 4865.6953125, 4861.6953125, 4573.6953125, 4837.6953125, 4523.6953125, 4865.6953125, 4855.6953125, 4559.697265625, 4829.697265625, 4421.6953125));
		}};

		parser.lerArquivo("src/assets/analysisMemory.out");

		assertEquals(array, parser.getBuffer());
	}

	@Test
	public void TesteLerArquivoSucessoAnalysisTime() throws ArquivoNaoEncontradoException {
		Parser parser = new Parser();
		@SuppressWarnings("serial")
		List<List<Double>> array = new ArrayList<List<Double>>() {{
			add(Arrays.asList(1110.0, 3200.0, 934.0, 2310.0, 3178.0, 4009.0, 737.0, 3121.0, 1976.0, 2573.0, 6291.0));
			add(Arrays.asList(413.0, 577.0, 410.0, 584.0, 866.0, 1075.0, 400.0, 701.0, 506.0, 720.0, 539.0));
			add(Arrays.asList(455.0, 690.0, 500.0, 456.0, 668.0, 726.0, 435.0, 580.0, 864.0, 444.0, 692.0));
			add(Arrays.asList(420.0, 561.0, 429.0, 564.0, 601.0, 627.0, 410.0, 496.0, 604.0, 750.0, 739.0));
			add(Arrays.asList(431.0, 619.0, 487.0, 682.0, 607.0, 702.0, 413.0, 779.0, 456.0, 505.0, 537.0));
			add(Arrays.asList(430.0, 475.0, 473.0, 857.0, 606.0, 848.0, 437.0, 490.0, 479.0, 671.0, 674.0));
			add(Arrays.asList(476.0, 647.0, 504.0, 556.0, 535.0, 722.0, 480.0, 529.0, 475.0, 643.0, 688.0));
			add(Arrays.asList(497.0, 475.0, 609.0, 578.0, 971.0, 496.0, 471.0, 708.0, 490.0, 618.0, 498.0));
			add(Arrays.asList(535.0, 542.0, 491.0, 638.0, 481.0, 765.0, 481.0, 487.0, 535.0, 1015.0, 652.0));
			add(Arrays.asList(558.0, 584.0, 563.0, 577.0, 645.0, 1061.0, 513.0, 523.0, 540.0, 612.0, 571.0));
			add(Arrays.asList(656.0, 705.0, 627.0, 943.0, 662.0, 728.0, 652.0, 628.0, 639.0, 660.0, 634.0));
			add(Arrays.asList(886.0, 1175.0, 844.0, 893.0, 1096.0, 1292.0, 854.0, 1014.0, 884.0, 1024.0, 862.0));
			add(Arrays.asList(2461.0, 2524.0, 2364.0, 2518.0, 2420.0, 2394.0, 2435.0, 2403.0, 2386.0, 2673.0, 2497.0));
			add(Arrays.asList(2291.0, 2280.0, 2272.0, 2379.0, 2281.0, 2258.0, 2305.0, 2308.0, 2320.0, 2275.0, 2305.0));
			add(Arrays.asList(4418.0, 4528.0, 4370.0, 4366.0, 4379.0, 4435.0, 4497.0, 4765.0, 4295.0, 4523.0, 4515.0));
			add(Arrays.asList(8717.0, 8814.0, 8604.0, 8670.0, 8799.0, 8472.0, 8742.0, 8687.0, 8792.0, 8865.0, 8581.0));
			add(Arrays.asList(18237.0, 17831.0, 17772.0, 17577.0, 18187.0, 17387.0, 17879.0, 17701.0, 18384.0, 17701.0, 18394.0));
			add(Arrays.asList(39222.0, 39442.0, 40082.0, 40192.0, 39168.0, 39137.0, 40017.0, 38000.0, 39967.0, 39049.0, 38238.0));
			add(Arrays.asList(120085.0, 118258.0, 119943.0, 116758.0, 119649.0, 121215.0, 113909.0, 114644.0, 115771.0, 107854.0, 115332.0));
			add(Arrays.asList(425823.0, 421734.0, 420526.0, 411620.0, 414876.0, 412099.0, 423135.0, 421929.0, 408435.0, 426251.0, 412203.0));
			add(Arrays.asList(892820.0, 850745.0, 878276.0, 877227.0, 876456.0, 866763.0, 858800.0, 860945.0, 868931.0, 883683.0, 867026.0));
		}};

		parser.lerArquivo("src/assets/analysisTime.out");

		assertEquals(array, parser.getBuffer());
	}

	@Test
	public void TesteLerArquivoVazio() throws ArquivoNaoEncontradoException {
		Parser parser = new Parser();

		List<List<Double>> array = new ArrayList<List<Double>>();

		parser.lerArquivo("src/assets/arquivoVazio.out");

		assertEquals(array, parser.getBuffer());
	}

	@Test(expected=ArquivoNaoEncontradoException.class)
	public void TesteLerArquivoInexistente() throws ArquivoNaoEncontradoException {
		Parser parser = new Parser();

		parser.lerArquivo("src/assets/arquivoInexistente.out");
	}


}
