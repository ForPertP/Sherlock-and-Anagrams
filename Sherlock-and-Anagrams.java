template <typename T, typename... Args>
constexpr bool all_equal(const T& value, const Args&... args)
{
    return ((value == args) && ...);
}

template<typename... Args>
constexpr auto sum(Args... args)
{
    return (args + ...);
}

    
int main()
{      
    std::cout << "All elements are equal to 1: " << all_equal(1) << '\n';
    std::cout << "All elements are equal to 0: " << all_equal(0, 0, 0) << '\n';
    std::cout << "All elements are equal to 1: " << all_equal(1, 1, 1, 1, 1) << '\n';
    std::cout << "All elements are equal to 1: " << all_equal(1, 2, 3, 4, 5) << '\n';


    std::cout << "Sum of 1, 2, 3, 4, 5: " << sum(1, 2, 3, 4, 5) << std::endl; // 15
    std::cout << "Sum of 1.5, 2.5, 3.5: " << sum(1.5, 2.5, 3.5) << std::endl;  // 7.5


    auto print_sum = [](auto... args)
        {
            std::cout << "Sum of given numbers: " << sum(args...) << std::endl;
        };

    print_sum(1, 2, 3, 4, 5);      // 15
    print_sum(1.5, 2.5, 3.5);      // 7.5
    print_sum(10, -20, 30, -40);   // -20


    return 0;
}

