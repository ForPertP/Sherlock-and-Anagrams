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
