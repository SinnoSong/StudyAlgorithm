namespace chapter1
{
    public static class GcdClass
    {
        public static int Gcd(int p, int q)
        {
            if (q == 0) return p;
            var r = p % q;
            return Gcd(q, r);
        }
    }
}
