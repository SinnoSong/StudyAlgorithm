using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace study_algorithm_csharp.chapter1.Tests
{
    [TestClass()]
    public class GcdClassTests
    {
        [TestMethod()]
        public void GcdTest()
        {
            int result = GcdClass.Gcd(100, 2);
            Assert.AreEqual(2, result);
        }
    }
}