import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dataset {

    private List<Double> numbers;
    private Map<Double, Integer> frequencyMap;
    private List<Double> mode;

    public Dataset(List<Double> numbers) {

        this.numbers = numbers;
        this.frequencyMap = new HashMap<>();
        this.mode = new ArrayList<>();

    }

    public double[] getMean() {

        double sum = calcSum();
        BigDecimal mean = BigDecimal.valueOf(sum / this.numbers.size());

        return new double[] {
            round(mean, 1),
            round(mean, 2)
        };

    }

    public double getMedian() {

        if (this.numbers.size() % 2 != 0) {

            return this.numbers.get(this.numbers.size() / 2);

        } else {

            return calcEvenMedian();

        }

    }

    public List<Double> getMode() {

        return findMode();

    }

    public double getRange() {

        double minVal = this.numbers.get(0);
        double maxVal = this.numbers.get(this.numbers.size() - 1);
        return (maxVal - minVal);

    }

    public double getStrdDev() {

        return -1;
    }

    public List<Double> firstQuartile() {

        return calcQuartile(1);

    }

    public List<Double> secondQuartile() {

        return calcQuartile(2);

    }

    public List<Double> thirdQuartile() {

        return calcQuartile(3);

    }

    public List<Double> interquartileRange() {

        return null;

    }

    private double calcSum() {

        double sum = 0;

        for (double num : this.numbers) {
            sum += num;
        }

        return sum;

    }

    private double round(BigDecimal val, int scale) {

        return val.setScale(scale, RoundingMode.HALF_UP).doubleValue();

    }

    private double calcEvenMedian() {

        double median1 = this.numbers.get((this.numbers.size() / 2) - 1);
        double median2 = this.numbers.get(this.numbers.size() / 2);
        return (median1 + median2) / 2;

    }

     private void calcFrequencyMap() {

        for (double currentNum : this.numbers) {
            frequencyMap.put(currentNum, frequencyMap.getOrDefault(currentNum, 0) + 1);
        }

    }

    private List<Double> findMode() {

        calcFrequencyMap();

        int maxCount = 0;

        for (Map.Entry<Double, Integer> entry : frequencyMap.entrySet()) {
            double currentNum = entry.getKey();
            int currentCount = entry.getValue();

            if (currentCount > maxCount) {

                mode.add(currentNum);
                maxCount = currentCount;

            } else if (currentCount == maxCount) {

                mode.add(currentNum);

            }
        }

        return mode;

    }

    public List<Double> calcQuartile(int quartile) {
        
        int quartileIndex = (int) Math.round(this.numbers.size() * (quartile / 4.0));
        double quartileVal = this.numbers.get(quartileIndex);

        List<Double> quartileList = new ArrayList<>();

        for (double num : this.numbers) {
            if (num < quartileVal) {

                quartileList.add(num);
        
            }
        }

        return quartileList;
        
    }

}