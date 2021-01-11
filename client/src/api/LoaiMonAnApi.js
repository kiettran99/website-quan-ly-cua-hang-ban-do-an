import axios from "../common/axiosClient";

export const getAllLoaiMonAn = async (options) => {
  let url = `/loaimonans`;
  if (options) {
    url = `/loaimonans?fields=${options.join(",")}`;
  }
  const response = await axios.get(url);
  return response.data;
};
export const getLoaiMonAn = async (id) => {
  const url = `/loaimonans/${id}`;
  const response = await axios.get(url);
  return response.data;
}
export const createOneLoaiMonAn = async (data) => {
  const url = `/loaimonans`;
  const response = await axios.post(url, data);
  return response.data;
};
export const removeLoaiMonAn = async (id, data) => {
  const url = `/loaimonans/${id}`;
  const response = await axios.delete(url, data);
  return response.data;
};
export const editLoaiMonAn = async (id, data) => {
  const url = `/loaimonans/${id}`;
  const response = await axios.put(url, data);
  return response.data;
};



