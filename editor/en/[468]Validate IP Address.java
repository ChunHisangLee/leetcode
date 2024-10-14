
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP.contains(".")) {
            if (isValidIPv4(queryIP)) {
                return "IPv4";
            }
        } else if (queryIP.contains(":")) {
            if (isValidIPv6(queryIP)) {
                return "IPv6";
            }
        }

        return "Neither";
    }

    private boolean isValidIPv4(String ip) {
        String[] parts = ip.split("\\.", -1);

        if (parts.length != 4) {
            return false;
        }

        for (String part : parts) {
            if (part.length() == 0 || part.length() > 3 || !part.matches("\\d+")) {
                return false;
            }

            if (part.startsWith("0") && part.length() > 1) {
                return false;
            }

            int num = Integer.parseInt(part);

            if (num < 0 || num > 255) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidIPv6(String ip) {
        String[] parts = ip.split(":", -1);

        if (parts.length != 8) {
            return false;
        }

        for (String part : parts) {
            if (part.length() == 0 || part.length() > 4 || !part.matches("[0-9a-fA-F]+")) {
                return false;
            }
        }

        return true;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
