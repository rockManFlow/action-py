local key = KEYS[1] --����KEY��һ��һ����
local limit = tonumber(ARGV[1])        --������С
local current = tonumber(redis.call('get', key) or "0")
if current + 1 > limit then --�������������С
   return 0
else  --������+1��������2�����
   redis.call("INCRBY", key,"1")
   redis.call("expire", key,"2")
   return 1
end