///**
// * Created by Yu on 2017/8/5.
// */
//public class lcmaxium {
//        public int maximalRectangle(char[][] matrix) {
//            // 含i 能包含的最大的 f[i][j] =  直接表示元素个数//表示
//            //这个思考点很赞，应该是以某个状态点出发，思考这个状态点处已经产生的高（连续纵向维1的情况） *（连续左边为1的情况 + 连续右边为1的情况 - 1 ）
//            //其中
//            if (matrix==null||matrix.length==0||matrix[0].length==0) {
//                return 0;
//            }
//            int m = matrix.length;
//            int n = matrix[0].length;
//            int[][] A = new int[m][n];
//
//            int[][] up = new int[m][n];
//            int[][] left = new int[m][n];
//            int[][] right = new int[m][n];
//            int i, j, k, l, r, res = 0;
//            for (i=0; i<m; ++i) {
//                for (j=0; j<n; ++j) {
//                    A[i][j] = matrix[i][j] - '0';
//                }
//            }
//
//
//            for (i=0; i<m; ++i) {
//                // 计算高
//                for (j=0; j<n; ++j) {
//                    if (A[i][j] == 0) {
//                        up[i][j] = 0;
//                    }
//                    else {
//                        up[i][j] = 1;
//                        if (i>0) {
//                            up[i][j] += up[i-1][j];//如果上一层连续，则++
//                        }
//                    }
//                }
//
//                // 计算左边
//                l = 0;
//                for (j=0; j<n; ++j) {
//                    if (A[i][j] == 0 ) {
//                        l = left[i][j] = 0;
//                    }
//                    else {
//                        ++l;
//                        left[i][j] = l;
//                        if ((i>0 && A[i-1][j] ) && (left[i-1][j] < left[i][j])){
//                            left[i][j] = left[i-1][j];//如果上一层短一点则取短一点
//                        }
//                    }
//                }
//
//                // 计算右边
//                r=0;
//                for (j=n-1; j>=0; --j) {
//                    if (A[i][j] == 0) {
//                        r = right[i][j] = 0;
//                    }
//                    else {
//                        ++r;
//                        right[i][j] = r;
//                        if (i>0&&A[i-1][j] && right[i-1][j] < right[i][j]) {
//                            right[i][j] = right[i-1][j];
//                        }
//                    }
//                }
//            }
//
//            for (i=0; i<m; ++i) {
//                for (j=0; j<n; ++j) {
//                    res = Math.max(res, up[i][j] * (left[i][j] + right[i][j] - 1));
//                }
//            }
//
//            return res;
//        }
//
//}
