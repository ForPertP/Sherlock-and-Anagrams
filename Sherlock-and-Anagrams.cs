using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Collections;
using System.ComponentModel;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Runtime.Serialization;
using System.Text.RegularExpressions;
using System.Text;
using System;

class Result
{
    private static int SherlockAndAnagramsByString(string s)
    {
        int result = 0;
        Dictionary<string, int> frequencyMap = new Dictionary<string, int>();

        for (int i = 0; i < s.Length; ++i)
        {
            for (int j = i; j < s.Length; ++j)
            {
                string sub = s.Substring(i, j - i + 1);
                char[] subArray = sub.ToCharArray();
                Array.Sort(subArray);
                string sortedSub = new string(subArray);
                if (frequencyMap.ContainsKey(sortedSub))
                    frequencyMap[sortedSub]++;
                else
                    frequencyMap[sortedSub] = 1;
            }
        }

        foreach (var pair in frequencyMap)
        {
            int count = pair.Value;
            result += (count * (count - 1)) / 2;
        }

        return result;
    }

    private static int SherlockAndAnagramsByArray(string s)
    {
        int result = 0;
        Dictionary<string, int> frequencyMap = new Dictionary<string, int>();

        for (int i = 0; i < s.Length; ++i)
        {
            int[] arr = new int[26];

            for (int j = i; j < s.Length; ++j)
            {
                arr[s[j] - 'a']++;
                string charFrequency = string.Join(",", arr);
                if (frequencyMap.ContainsKey(charFrequency))
                    frequencyMap[charFrequency]++;
                else
                    frequencyMap[charFrequency] = 1;
            }
        }

        foreach (var pair in frequencyMap)
        {
            int count = pair.Value;
            result += (count * (count - 1)) / 2;
        }

        return result;
    }

    public static int sherlockAndAnagrams(string s)
    {
        if (s.Length < 50)
            return SherlockAndAnagramsByString(s);
        else
            return SherlockAndAnagramsByArray(s);
    }
}

class Solution
{
    public static void Main(string[] args)
    {
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        int q = Convert.ToInt32(Console.ReadLine().Trim());

        for (int qItr = 0; qItr < q; qItr++)
        {
            string s = Console.ReadLine();

            int result = Result.sherlockAndAnagrams(s);

            textWriter.WriteLine(result);
        }

        textWriter.Flush();
        textWriter.Close();
    }
}
