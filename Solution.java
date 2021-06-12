package maximalPointsFromDeletingTwoCharacterSubstrings.gitHub;

public class Solution {

    /*
    By the problem design on binarysearch.com, we have to work
    around the given method 'public int solve(String s, int zeroone, int onezero)'
    so that the code can be run on the website. Even though the name 'solve' 
    does not make a lot of sense, it is left as it is, so that the code can 
    be run directly on the website, without any modifications.
     */
    public int solve(String s, int zeroone, int onezero) {

        return calculate_maximumPointsForDeletingPairsOfChars(s, zeroone, onezero);
    }

    /*
    1. Deteremine which of both pairs get maximum points.
    2. Extract all pairs that get maximum points.
    3. Determine the number of all possible pairs, both with maximum and with minimum poitns.
    4. Determine the number of pairs with minimum points, on the basis of steps 2 and 3.
    5. Multily the respective pairs with their points and sum the result for both.
     */
    public int calculate_maximumPointsForDeletingPairsOfChars(String s, int zeroone, int onezero) {
        char firstDigitOfMaxPointsPair = zeroone > onezero ? '0' : '1';

        int maxPointsPerPair = zeroone > onezero ? zeroone : onezero;
        int minPointsPerPair = zeroone < onezero ? zeroone : onezero;

        int numberOfPairsForMaxPoints = 0;
        int numberOfPairsForMinPoints = 0;

        int numberOfOnesInString = 0;
        int numberOfZerosInString = 0;

        int occurance_firstDigitOfMaxPointsPair = 0;

        //Within this loop we extract all pairs that have max points.
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            numberOfOnesInString += ch - '0';

            if (ch == firstDigitOfMaxPointsPair) {
                occurance_firstDigitOfMaxPointsPair++;
            } else if (occurance_firstDigitOfMaxPointsPair > 0) {
                numberOfPairsForMaxPoints++;
                occurance_firstDigitOfMaxPointsPair--;
            }
        }

        numberOfZerosInString = s.length() - numberOfOnesInString;

        /*
        Since a pair consists of one '0' and one '1' and a pair could be either '01' or '10',
        then the total number of pairs in the string is equal to the frequency of the digit 
        that occurs less in the string.
         */
        int numberOfPairsInString = Math.min(numberOfZerosInString, numberOfOnesInString);

        numberOfPairsForMinPoints = numberOfPairsInString - numberOfPairsForMaxPoints;

        return numberOfPairsForMaxPoints * maxPointsPerPair + numberOfPairsForMinPoints * minPointsPerPair;
    }
}
