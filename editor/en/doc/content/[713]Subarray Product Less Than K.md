<p>Given an array of integers <code>nums</code> and an integer <code>k</code>, return <em>the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than </em><code>k</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [10,5,2,6], k = 100
<strong>Output:</strong> 8
<strong>Explanation:</strong> The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3], k = 0
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li> 
 <li><code>1 &lt;= nums[i] &lt;= 1000</code></li> 
 <li><code>0 &lt;= k &lt;= 10<sup>6</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Sliding Window</details><br>

<div>ð 6037, ð 194<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug åé¦</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jbæä»¶ç®ä»' target='_blank' style='color: lightgray;text-decoration: underline;'>ä½¿ç¨æå</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>æ´å¤éå¥æä»¶</a></span></span></div>

<div id="labuladong"><hr>

</div>



ç®æ³å¯è§åç¼è¾å¨ä¸çº¿ï¼[ç¹å»ä½éª](https://labuladong.online/algo/intro/visualize/)ï¼**

<details><summary><strong>labuladong æè·¯</strong></summary>

<!-- vip -->
<!-- i_62b43720e4b07bd2d7b1b6dd -->

æ¬é¢æè·¯ä¸º labuladong ç½ç«ä¼åä¸å±ï¼[ç¹å»è¿é](https://labuladong.online/algo/intro/site-vip/) æ¥çåä¸ªæä»¶çè§£éæ¹æ³ãå¦éå°é®é¢ï¼å¯ä»¥å¨ææ«å æå¾®ä¿¡ç´æ¥åé¦ã</details>
</div>

