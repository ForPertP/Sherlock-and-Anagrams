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
    map<vector<int>, int> mp;

    for (int i = 0; i < s.size(); ++i)
    {
        vector<int> arr(26, 0);
        
        for (int j = i; j < s.size(); ++j)
        {
            arr[s[j] - 'a']++;
            mp[arr]++;
        }
    }

    for( const auto &it : mp )
    {
        int count = it.second;
        result += ((count) * (count - 1)) / 2;
    }

    return result;
}
