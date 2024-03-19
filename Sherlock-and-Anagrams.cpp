#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);

/*
 * Complete the 'sherlockAndAnagrams' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts STRING s as parameter.
 */

int sherlockAndAnagrams(string s)
{
    int result = 0;
    std::unordered_map<string, int> frequencyMap;

    for (int i = 0; i < s.size(); ++i)
    {
        for (int j = i; j < s.size(); ++j)
        {
            string sub = s.substr(i, j - i + 1);
            sort(sub.begin(), sub.end());
            frequencyMap[sub]++;
        }
    }

    for (const auto &pair : frequencyMap)
    {
        int count = pair.second;
        result += (count * (count - 1)) / 2;
    }

    return result;
}


int sherlockAndAnagrams2(string s)
{
    int result = 0;
    std::map<vector<int>, int> frequencyMap;

    for (int i = 0; i < s.size(); ++i)
    {
        vector<int> arr(26, 0);
        
        for (int j = i; j < s.size(); ++j)
        {
            arr[s[j] - 'a']++;
            frequencyMap[arr]++;
        }
    }

    for (const auto& [charFrequency, count] : frequencyMap)
    {
        result += (count * (count - 1)) / 2;
    }

    return result;
}


int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string q_temp;
    getline(cin, q_temp);

    int q = stoi(ltrim(rtrim(q_temp)));

    for (int q_itr = 0; q_itr < q; q_itr++) {
        string s;
        getline(cin, s);

        int result = sherlockAndAnagrams(s);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}

string ltrim(const string &str) {
    string s(str);

    s.erase(
        s.begin(),
        find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace)))
    );

    return s;
}

string rtrim(const string &str) {
    string s(str);

    s.erase(
        find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(),
        s.end()
    );

    return s;
}
