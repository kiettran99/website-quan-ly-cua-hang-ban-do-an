import axios from "../common/axiosClient";

export const checkoutOrder = async (data) => {
    const url = `/orders/checkout`;
    const response = await axios.post(url, data);
    return response.data;
};