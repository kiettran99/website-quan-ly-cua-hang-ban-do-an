import axios from "../common/axiosClient";

export const getMonAns = async (options) => {
  const url = `/monans`;
  if (options) {
    url = `/monans?fields=${options.join(",")}`;
  }
  const response = await axios.get(url);
  return response.data;
};

export const getMonAn = async (id) => {
  const url = `/monans/${id}`;
  const response = await axios.get(url);
  return response.data;
}

export const createOneMonAn = async (data) => {
  const url = `/monans`;
  const response = await axios.post(url, data);
  return response.data;
};

export const editMonAn = async (id, data) => {
  const url = `/monans/${id}`;
  const response = await axios.put(url, data);
  return response.data;
};

export const removeMonAn = async (id, data) => {
  const url = `/monans/${id}`;
  const response = await axios.delete(url, data);
  return response.data;
};
